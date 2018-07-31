package info.mjy.tools;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

    @Test
    public void findText() {
        String str = "qweqw[as]das[]das[adc]dfs[d]dg";

        String regex = "(\\[[^\\]]*\\])";
        String regex2 = "\\[(.*?)\\]";

        printRegex(str, regex2);
    }

    @Test
    public void findText2() {
        String str = "花呗支付服务费[2018032721001001570586356390];淘宝交易号[T200P141516028694009018]";
        String regex = "\\[[^\\]]*\\]";
        printRegex(str, regex);
    }

    @Test
    public void findText3() {
        String str = "花呗支付服务费{2018032721001001570586356390};淘宝交易号{T200P141516028694009018}";
        List<String> list = Lists.newArrayList();
//        for (int i = str.indexOf("["); i < str.lastIndexOf("["); i++) {
//            str = str.substring(i);
//        }

//        String str = "您好{options{a{ddddddd}bc}}评论{}了您的{options{def}}";
        findText4(list, str, 0);

        for (String tempStr : list) {
            System.out.println(tempStr);
        }
    }

    /**
     * 可以获取花括号中的内容
     * @param list
     * @param str
     * @param index
     */
    private void findText4(List<String> list, String str, int index) {
        if (str.charAt(index) == '{') {
            int startIndex = index, endIndex = 0;
            int count = 0;
            for (int i = index; i < str.length(); i++) {
                if (str.charAt(i) == '{') {
                    if (count == 0) {
                        startIndex = i;
                    }
                    count++;
                }
                if (str.charAt(i) == '}') {
                    count--;
                    if (count == 0) {
                        endIndex = i;
                        list.add(str.substring(startIndex, endIndex + 1));
                        break;
                    }
                }
            }
        }
        if (index < str.length() - 1) {
            this.findText4(list, str, index + 1);
        }
    }

    private void printRegex(String str, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            System.out.println(matcher.group().substring(1, matcher.group().length() - 1));
        }
    }

}
