package ransom_note;

public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        final var charSupplies = new int[26];
        final var magazineChars = magazine.toCharArray();
        final var ransomChars = ransomNote.toCharArray();

        for (final var character : magazineChars) {
            charSupplies[character - 'a']++;
        }
        for (final var character : ransomChars) {
            final var supply = charSupplies[character - 'a']--;
            if (supply <= 0) {
                return false;
            }
        }

        return true;
    }
}
