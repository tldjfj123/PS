import java.util.*;

// 노래를 장르별로 2개씩 

/**
우선순위
1. 재생수 합 많은 장르
2. 장르 내에서 재생수
3. 장르 내에서 재생수가 같으면 고유번호가 낮은 노래 (index)
*/

class Solution {
    class Song implements Comparable<Song> {
        int index;
        int play;

        public Song(int index, int play) {
            this.index = index;
            this.play = play;
        }

        @Override
        public int compareTo(Song other) {
            if (this.play == other.play) {
                return this.index - other.index; // 인덱스 오름차순
            }
            return other.play - this.play; // 재생 횟수 내림차순
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genreTotal = new HashMap<>();
        Map<String, List<Song>> songsByGenre = new HashMap<>();

        // 1. 장르별 총 재생 수 계산 + 노래 분류
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            
            genreTotal.put(genre, genreTotal.getOrDefault(genre, 0) + play);
            songsByGenre.computeIfAbsent(genre, k -> new ArrayList<>()).add(new Song(i, play));
        }

        // 2. 장르를 총 재생 수 내림차순으로 정렬
        List<String> sortedGenres = new ArrayList<>(genreTotal.keySet());
        sortedGenres.sort((a, b) -> genreTotal.get(b) - genreTotal.get(a));

        // 3. 각 장르에서 상위 2개 노래 선택
        List<Integer> result = new ArrayList<>();
        for (String genre : sortedGenres) {
            List<Song> songs = songsByGenre.get(genre);
            Collections.sort(songs);
            
            int limit = Math.min(2, songs.size());
            for (int i = 0; i < limit; i++) {
                result.add(songs.get(i).index);
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}
