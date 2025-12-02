import string.StringInterview;

public class Main {
    public static void main(String[] arg) {
        System.out.println("Pragram start from here ---- !");
        StringInterview strObj = new StringInterview();

        strObj.checkIsAnagram("silent", "listen");
        strObj.isStringIsogram("helo");
        strObj.findUniqueCharacter("success");
        strObj.findFirstNonRepeatingCharacter("swiss");
        strObj.convertStringToCamelCase("my name is Rajesh rathore from delhi");
        strObj.countWords("my name is rajesh");
        strObj.removeDuplicates("bcabc");
        strObj.mostRepeatingCharacter("apple");
        strObj.findLargestWordInString("java makes coding enjayable and challenging");
    }
}
