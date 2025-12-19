
import tryouts.*;

void main() {
    IO.println("Hello and welcome!");

    /*for (int i = 1; i <= 5; i++) {
        IO.println("i = " + i);
    }*/

    for(int i : IntStream.range(0,5).toArray()) {
        IO.println("i = " + i);
    }

    TryString.findFirstNonRepeatedCharacterA1("swiss");
    TryString.findFirstNonRepeatedCharacterA2("swiss");
    TryString.checkAnagrams("listen", "silent");
    TryString.findFirstRepeatedCharacter("programming");
    TryString.countCharacterFrequency("success");
    TryString.reverseEachWord("Java Developer");
    TryString.findLongestWordInSentence("I am learning Spring Boot");
    TryString.checkStringRotation("waterbottle", "erbottlewat");
    TryString.findDuplicateWords("This is a test. This test is only a test.");
    TryString.hasStringOnlyDigits("123456");
    TryString.removeDuplicateCharacters("programming");
    TryString.recursiveStringPermutations("abc"," ");
    TryString.findMostRepeatedCharacter("characteristics");
    TryString.checkUniqueCharacters("abcdefg");
    TryString.reverseWordsOrder("This is a sample sentence");
    TryString.stringCompression("aaabbbcccaaa");
    TryString.longestPalindromicSubstring("babad");

}
