package offer.problem50;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description 50.2. 字符流中第一个不重复的字符
 * @Date 2019-02-04
 * @Time 17:42
 */
public class FirstNotRepeatingCharInStream {
    private String str = "";
    private int[] data = new int[256];

    public void insert(char ch) {
        str += ch;
        data[ch]++;
    }

    public char find() {
        if (str.length() <= 0) {
            return '#';
        }
        char[] chars = str.toCharArray();
        for (char c : chars) {
            if (data[c] == 1) {
                return c;
            }
        }
        return '#';
    }

    public static void main(String[] args) {
        //ggg#ll
        FirstNotRepeatingCharInStream stream = new FirstNotRepeatingCharInStream();
        stream.insert('g');
        System.out.println(stream.find());
        stream.insert('o');
        System.out.println(stream.find());
        stream.insert('o');
        System.out.println(stream.find());
        stream.insert('g');
        System.out.println(stream.find());
        stream.insert('l');
        System.out.println(stream.find());
        stream.insert('e');
        System.out.println(stream.find());
    }
}
