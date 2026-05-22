
import tryouts.*;
import tryouts.leetcodeTryouts.LeetCodeProblems;

import java.util.stream.IntStream;

void main() {
    IO.println("Hello and welcome!");

    /*for (int i = 1; i <= 5; i++) {
        IO.println("i = " + i);
    }*/

    for(int i : IntStream.range(0,5).toArray()) {
        IO.println("i = " + i);
    }

    System.out.println("##############################################################################");
    TryThoughts.printEmailDomain("akhil.gajulavarti@hotmail.com");
    System.out.println("##############################################################################");
    TryThoughts.printEmailHostName("akhil.gajulavarti@abc.def.ghi.jkl.com");
    System.out.println("##############################################################################");
    TryString.findFirstNonRepeatedCharacterA1("swiss");
    System.out.println("##############################################################################");
    TryString.findFirstNonRepeatedCharacterA2("swiss");
    System.out.println("##############################################################################");
    TryString.checkAnagrams("listen", "silent");
    System.out.println("##############################################################################");
    TryString.findFirstRepeatedCharacter("programming");
    System.out.println("##############################################################################");
    TryString.countCharacterFrequency("success");
    System.out.println("##############################################################################");
    TryString.reverseEachWord("Java Developer");
    System.out.println("##############################################################################");
    TryString.findLongestWordInSentence("I am learning Spring Boot");
    System.out.println("##############################################################################");
    TryString.checkStringRotation("waterbottle", "erbottlewat");
    System.out.println("##############################################################################");
    TryString.findDuplicateWords("This is a test. This test is only a test.");
    System.out.println("##############################################################################");
    TryString.hasStringOnlyDigits("123456");
    System.out.println("##############################################################################");
    TryString.removeDuplicateCharacters("programming");
    System.out.println("##############################################################################");
    TryString.recursiveStringPermutations("abc"," ");
    System.out.println("##############################################################################");
    TryString.findMostRepeatedCharacter("characteristics");
    System.out.println("##############################################################################");
    TryString.checkUniqueCharacters("abcdefg");
    System.out.println("##############################################################################");
    TryString.reverseWordsOrder("This is a sample sentence");
    System.out.println("##############################################################################");
    TryString.stringCompression("aaabbbcccaaa");
    System.out.println("##############################################################################");
    TryString.longestPalindromicSubstring("babad");
    System.out.println("##############################################################################");
    LeetCodeProblems.waterContainer();
    System.out.println("##############################################################################");
    TryLists.createList();
    TryLists.secondLargestA2();
    System.out.println("##############################################################################");
    TryMaps.wordFrequencyA1();
    TryMaps.sortByValues();
    System.out.println("##############################################################################");
    TrySets.intersection();
    TrySets.findDuplicates();
    System.out.println("##############################################################################");
    TryQueues.basicOperations();
    TryQueues.kthLargest();
    System.out.println("##############################################################################");
    TryDeques.useAsStack();
    TryDeques.slidingWindowMaximum();
    System.out.println("##############################################################################");
    TryTrees.inorderTraversal();
    TryTrees.validateBst();
    System.out.println("##############################################################################");

}
