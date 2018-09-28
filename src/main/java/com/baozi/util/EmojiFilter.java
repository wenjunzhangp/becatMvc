package com.baozi.util;

import com.vdurmont.emoji.EmojiParser;
import org.apache.commons.lang.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * 过滤emoji表情与非emoji表情
 *
 * @author hsw
 */
public class EmojiFilter {

    private static Pattern stringfilter = Pattern.compile("[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？·]");

    // 过滤特殊字符
    public static String stringFilter(String str) throws PatternSyntaxException {
        Matcher m = stringfilter.matcher(str);
        return m.replaceAll("").trim();
    }

    public final static String unicodeReg = "[" +
            "\u4E00-\u9FBF" +//：CJK 统一表意符号 (CJK Unified Ideographs)
            "\u4DC0-\u4DFF" +//：易经六十四卦符号 (Yijing Hexagrams Symbols)
            "\u0000-\u007F" +//：C0控制符及基本拉丁文 (C0 Control and Basic Latin)
            "\u0080-\u00FF" +//：C1控制符及拉丁：补充-1 (C1 Control and Latin 1 Supplement)
            "\u0100-\u017F" +//：拉丁文扩展-A (Latin Extended-A)
            "\u0180-\u024F" +//：拉丁文扩展-B (Latin Extended-B)
            "\u0250-\u02AF" +//：国际音标扩展 (IPA Extensions)
            "\u02B0-\u02FF" +//：空白修饰字母 (Spacing Modifiers)
            "\u0300-\u036F" +//：结合用读音符号 (Combining Diacritics Marks)
            "\u0370-\u03FF" +//：希腊文及科普特文 (Greek and Coptic)
            "\u0400-\u04FF" +//：西里尔字母 (Cyrillic)
            "\u0500-\u052F" +//：西里尔字母补充 (Cyrillic Supplement)
            "\u0530-\u058F" +//：亚美尼亚语 (Armenian)
            "\u0590-\u05FF" +//：希伯来文 (Hebrew)
            "\u0600-\u06FF" +//：阿拉伯文 (Arabic)
            "\u0700-\u074F" +//：叙利亚文 (Syriac)
            "\u0750-\u077F" +//：阿拉伯文补充 (Arabic Supplement)
            "\u0780-\u07BF" +//：马尔代夫语 (Thaana)
            //"\u07C0-\u077F"+//：西非书面语言 (N'Ko)
            "\u0800-\u085F" +//：阿维斯塔语及巴列维语 (Avestan and Pahlavi)
            "\u0860-\u087F" +//：Mandaic
            "\u0880-\u08AF" +//：撒马利亚语 (Samaritan)
            "\u0900-\u097F" +//：天城文书 (Devanagari)
            "\u0980-\u09FF" +//：孟加拉语 (Bengali)
            "\u0A00-\u0A7F" +//：锡克教文 (Gurmukhi)
            "\u0A80-\u0AFF" +//：古吉拉特文 (Gujarati)
            "\u0B00-\u0B7F" +//：奥里亚文 (Oriya)
            "\u0B80-\u0BFF" +//：泰米尔文 (Tamil)
            "\u0C00-\u0C7F" +//：泰卢固文 (Telugu)
            "\u0C80-\u0CFF" +//：卡纳达文 (Kannada)
            "\u0D00-\u0D7F" +//：德拉维族语 (Malayalam)
            "\u0D80-\u0DFF" +//：僧伽罗语 (Sinhala)
            "\u0E00-\u0E7F" +//：泰文 (Thai)
            "\u0E80-\u0EFF" +//：老挝文 (Lao)
            "\u0F00-\u0FFF" +//：藏文 (Tibetan)
            "\u1000-\u109F" +//：缅甸语 (Myanmar)
            "\u10A0-\u10FF" +//：格鲁吉亚语 (Georgian)
            "\u1100-\u11FF" +//：朝鲜文 (Hangul Jamo)
            "\u1200-\u137F" +//：埃塞俄比亚语 (Ethiopic)
            "\u1380-\u139F" +//：埃塞俄比亚语补充 (Ethiopic Supplement)
            "\u13A0-\u13FF" +//：切罗基语 (Cherokee)
            "\u1400-\u167F" +//：统一加拿大土著语音节 (Unified Canadian Aboriginal Syllabics)
            "\u1680-\u169F" +//：欧甘字母 (Ogham)
            "\u16A0-\u16FF" +//：如尼文 (Runic)
            "\u1700-\u171F" +//：塔加拉语 (Tagalog)
            "\u1720-\u173F" +//：Hanunóo
            "\u1740-\u175F" +//：Buhid
            "\u1760-\u177F" +//：Tagbanwa
            "\u1780-\u17FF" +//：高棉语 (Khmer)
            "\u1800-\u18AF" +//：蒙古文 (Mongolian)
            "\u18B0-\u18FF" +//：Cham
            "\u1900-\u194F" +//：Limbu
            "\u1950-\u197F" +//：德宏泰语 (Tai Le)
            "\u1980-\u19DF" +//：新傣仂语 (New Tai Lue)
            "\u19E0-\u19FF" +//：高棉语记号 (Kmer Symbols)
            "\u1A00-\u1A1F" +//：Buginese
            "\u1A20-\u1A5F" +//：Batak
            "\u1A80-\u1AEF" +//：Lanna
            "\u1B00-\u1B7F" +//：巴厘语 (Balinese)
            "\u1B80-\u1BB0" +//：巽他语 (Sundanese)
            "\u1BC0-\u1BFF" +//：Pahawh Hmong
            "\u1C00-\u1C4F" +//：雷布查语(Lepcha)
            "\u1C50-\u1C7F" +//：Ol Chiki
            "\u1C80-\u1CDF" +//：曼尼普尔语 (Meithei/Manipuri)
            "\u1D00-\u1D7F" +//：语音学扩展 (Phone tic Extensions)
            "\u1D80-\u1DBF" +//：语音学扩展补充 (Phonetic Extensions Supplement)
            "\u1DC0-\u1DFF" +//结合用读音符号补充 (Combining Diacritics Marks Supplement)
            "\u1E00-\u1EFF" +//：拉丁文扩充附加 (Latin Extended Additional)
            "\u1F00-\u1FFF" +//：希腊语扩充 (Greek Extended)
            "\u2000-\u206F" +//：常用标点 (General Punctuation)
            "\u2070-\u209F" +//：上标及下标 (Superscripts and Subscripts)
            "\u20A0-\u20CF" +//：货币符号 (Currency Symbols)
            "\u20D0-\u20FF" +//：组合用记号 (Combining Diacritics Marks for Symbols)
            "\u2100-\u214F" +//：字母式符号 (Letterlike Symbols)
            "\u2150-\u218F" +//：数字形式 (Number Form)
            "\u2190-\u21FF" +//：箭头 (Arrows)
            "\u2200-\u22FF" +//：数学运算符 (Mathematical Operator)
            "\u2300-\u23FF" +//：杂项工业符号 (Miscellaneous Technical)
            "\u2400-\u243F" +//：控制图片 (Control Pictures)
            "\u2440-\u245F" +//：光学识别符 (Optical Character Recognition)
            "\u2460-\u24FF" +//：封闭式字母数字 (Enclosed Alphanumerics)
            "\u2500-\u257F" +//：制表符 (Box Drawing)
            "\u2580-\u259F" +//：方块元素 (Block Element)
            "\u25A0-\u25FF" +//：几何图形 (Geometric Shapes)
            "\u2600-\u26FF" +//：杂项符号 (Miscellaneous Symbols)
            "\u2700-\u27BF" +//：印刷符号 (Dingbats)
            "\u27C0-\u27EF" +//：杂项数学符号-A (Miscellaneous Mathematical Symbols-A)
            "\u27F0-\u27FF" +//：追加箭头-A (Supplemental Arrows-A)
            "\u2800-\u28FF" +//：盲文点字模型 (Braille Patterns)
            "\u2900-\u297F" +//：追加箭头-B (Supplemental Arrows-B)
            "\u2980-\u29FF" +//：杂项数学符号-B (Miscellaneous Mathematical Symbols-B)
            "\u2A00-\u2AFF" +//：追加数学运算符 (Supplemental Mathematical Operator)
            "\u2B00-\u2BFF" +//：杂项符号和箭头 (Miscellaneous Symbols and Arrows)
            "\u2C00-\u2C5F" +//：格拉哥里字母 (Glagolitic)
            "\u2C60-\u2C7F" +//：拉丁文扩展-C (Latin Extended-C)
            "\u2C80-\u2CFF" +//：古埃及语 (Coptic)
            "\u2D00-\u2D2F" +//：格鲁吉亚语补充 (Georgian Supplement)
            "\u2D30-\u2D7F" +//：提非纳文 (Tifinagh)
            "\u2D80-\u2DDF" +//：埃塞俄比亚语扩展 (Ethiopic Extended)
            "\u2E00-\u2E7F" +//：追加标点 (Supplemental Punctuation)
            "\u2E80-\u2EFF" +//：CJK 部首补充 (CJK Radicals Supplement)
            "\u2F00-\u2FDF" +//：康熙字典部首 (Kangxi Radicals)
            "\u2FF0-\u2FFF" +//：表意文字描述符 (Ideographic Description Characters)
            "\u3000-\u303F" +//：CJK 符号和标点 (CJK Symbols and Punctuation)
            "\u3040-\u309F" +//：日文平假名 (Hiragana)
            "\u30A0-\u30FF" +//：日文片假名 (Katakana)
            "\u3100-\u312F" +//：注音字母 (Bopomofo)
            "\u3130-\u318F" +//：朝鲜文兼容字母 (Hangul Compatibility Jamo)
            "\u3190-\u319F" +//：象形字注释标志 (Kanbun)
            "\u31A0-\u31BF" +//：注音字母扩展 (Bopomofo Extended)
            "\u31C0-\u31EF" +//：CJK 笔画 (CJK Strokes)
            "\u31F0-\u31FF" +//：日文片假名语音扩展 (Katakana Phonetic Extensions)
            "\u3200-\u32FF" +//：封闭式 CJK 文字和月份 (Enclosed CJK Letters and Months)
            "\u3300-\u33FF" +//：CJK 兼容 (CJK Compatibility)
            "\u3400-\u4DBF" +//：CJK 统一表意符号扩展 A (CJK Unified Ideographs Extension A)
            "\u4DC0-\u4DFF" +//：易经六十四卦符号 (Yijing Hexagrams Symbols)
            "\u4E00-\u9FBF" +//：CJK 统一表意符号 (CJK Unified Ideographs)
            "\uA000-\uA48F" +//：彝文音节 (Yi Syllables)
            "\uA490-\uA4CF" +//：彝文字根 (Yi Radicals)
            "\uA500-\uA61F" +//：Vai
            "\uA660-\uA6FF" +//：统一加拿大土著语音节补充 (Unified Canadian Aboriginal Syllabics Supplement)
            "\uA700-\uA71F" +//：声调修饰字母 (Modifier Tone Letters)
            "\uA720-\uA7FF" +//：拉丁文扩展-D (Latin Extended-D)
            "\uA800-\uA82F" +//：Syloti Nagri
            "\uA840-\uA87F" +//：八思巴字 (Phags-pa)
            "\uA880-\uA8DF" +//：Saurashtra
            "\uA900-\uA97F" +//：爪哇语 (Javanese)
            "\uA980-\uA9DF" +//：Chakma
            "\uAA00-\uAA3F" +//：Varang Kshiti
            "\uAA40-\uAA6F" +//：Sorang Sompeng
            "\uAA80-\uAADF" +//：Newari
            "\uAB00-\uAB5F" +//：越南傣语 (Vi?t Thái)
            "\uAB80-\uABA0" +//：Kayah Li
            "\uAC00-\uD7AF" +//：朝鲜文音节 (Hangul Syllables)
            //"\uD800-\uDBFF"+//：High-half zone of UTF-16
            //"\uDC00-\uDFFF"+//：Low-half zone of UTF-16
            "\uE000-\uF8FF" +//：自行使用区域 (Private Use Zone)
            "\uF900-\uFAFF" +//：CJK 兼容象形文字 (CJK Compatibility Ideographs)
            "\uFB00-\uFB4F" +//：字母表达形式 (Alphabetic Presentation Form)
            "\uFB50-\uFDFF" +//：阿拉伯表达形式A (Arabic Presentation Form-A)
            "\uFE00-\uFE0F" +//：变量选择符 (Variation Selector)
            "\uFE10-\uFE1F" +//：竖排形式 (Vertical Forms)
            "\uFE20-\uFE2F" +//：组合用半符号 (Combining Half Marks)
            "\uFE30-\uFE4F" +//：CJK 兼容形式 (CJK Compatibility Forms)
            "\uFE50-\uFE6F" +//：小型变体形式 (Small Form Variants)
            "\uFE70-\uFEFF" +//：阿拉伯表达形式B (Arabic Presentation Form-B)
            "\uFF00-\uFFEF" +//：半型及全型形式 (Halfwidth and Fullwidth Form)
            "\uFFF0-\uFFFF]";//：特殊 (Specials);

    /**
     * 将字符串转成unicode
     *
     * @param str 待转字符串
     * @return unicode字符串
     */
    public static String convert(String str) {
        str = (str == null ? "" : str);
        String tmp;
        StringBuffer sb = new StringBuffer(1000);
        char c;
        int i, j;
        sb.setLength(0);
        for (i = 0; i < str.length(); i++) {
            c = str.charAt(i);
            sb.append("\\u");
            j = (c >>> 8); //取出高8位
            tmp = Integer.toHexString(j);
            if (tmp.length() == 1) {
                sb.append("0");
            }
            sb.append(tmp);
            j = (c & 0xFF); //取出低8位
            tmp = Integer.toHexString(j);
            if (tmp.length() == 1) {
                sb.append("0");
            }
            sb.append(tmp);

        }
        return (new String(sb).toUpperCase());
    }


    /**
     * 2)unicode转成字符串，与上述过程反向操作即可
     * 将unicode 字符串
     *
     * @param str 待转字符串
     * @return 普通字符串
     */
    public static String revert(String str) {
        str = (str == null ? "" : str);
        if (str.indexOf("\\u") == -1)//如果不是unicode码则原样返回
            return str;

        StringBuffer sb = new StringBuffer(1000);

        for (int i = 0; i < str.length() - 6; ) {
            String strTemp = str.substring(i, i + 6);
            String value = strTemp.substring(2);
            int c = 0;
            for (int j = 0; j < value.length(); j++) {
                char tempChar = value.charAt(j);
                int t = 0;
                switch (tempChar) {
                    case 'a':
                        t = 10;
                        break;
                    case 'b':
                        t = 11;
                        break;
                    case 'c':
                        t = 12;
                        break;
                    case 'd':
                        t = 13;
                        break;
                    case 'e':
                        t = 14;
                        break;
                    case 'f':
                        t = 15;
                        break;
                    default:
                        t = tempChar - 48;
                        break;
                }

                c += t * ((int) Math.pow(16, (value.length() - j - 1)));
            }
            sb.append((char) c);
            i = i + 6;
        }
        return sb.toString();
    }

    public static String emojiChange(String string) {
        System.out.println("__________________________________");
        try {
            System.out.println("all-string:" + string);
            System.out.println("all-unicode:" + convert(string));
            Pattern pattern = Pattern.compile(unicodeReg);
            StringBuffer sbBuffer = new StringBuffer();
            for (int i = 0; i < string.length(); i++) {
                char c = string.charAt(i);
                String temp = String.valueOf(c);
                Matcher matcher = pattern.matcher(temp);
                if (matcher.find()) {
                    sbBuffer.append(temp);
                } else {
                    sbBuffer.append("□");
                }
                System.out.println("temp:" + temp + ";unicode:" + convert(temp));
            }
            System.out.println("sb:" + sbBuffer.toString());
            System.out.println("--------------------------------------");
            return sbBuffer.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static boolean containsEmoji(String source) {
        int len = source.length();
        boolean isEmoji = false;
        for (int i = 0; i < len; i++) {
            char hs = source.charAt(i);
            if (0xd800 <= hs && hs <= 0xdbff) {
                if (source.length() > 1) {
                    char ls = source.charAt(i + 1);
                    int uc = ((hs - 0xd800) * 0x400) + (ls - 0xdc00) + 0x10000;
                    if (0x1d000 <= uc && uc <= 0x1f77f) {
                        return true;
                    }
                }
            } else {
                // non surrogate
                if (0x2100 <= hs && hs <= 0x27ff && hs != 0x263b) {
                    return true;
                } else if (0x2B05 <= hs && hs <= 0x2b07) {
                    return true;
                } else if (0x2934 <= hs && hs <= 0x2935) {
                    return true;
                } else if (0x3297 <= hs && hs <= 0x3299) {
                    return true;
                } else if (hs == 0xa9 || hs == 0xae || hs == 0x303d
                        || hs == 0x3030 || hs == 0x2b55 || hs == 0x2b1c
                        || hs == 0x2b1b || hs == 0x2b50 || hs == 0x231a) {
                    return true;
                }
                if (!isEmoji && source.length() > 1 && i < source.length() - 1) {
                    char ls = source.charAt(i + 1);
                    if (ls == 0x20e3) {
                        return true;
                    }
                }
            }
        }
        return isEmoji;
    }

    private static boolean isEmojiCharacter(char codePoint) {
        return (codePoint == 0x0) || (codePoint == 0x9) || (codePoint == 0xA)
                || (codePoint == 0xD)
                || ((codePoint >= 0x20) && (codePoint <= 0xD7FF))
                || ((codePoint >= 0xE000) && (codePoint <= 0xFFFD))
                || ((codePoint >= 0x10000) && (codePoint <= 0x10FFFF));
    }

    /**
     * 过滤emoji 或者 其他非文字类型的字符
     *
     * @param source
     * @return
     */
    public static String filterEmoji(String source) {
        if (StringUtils.isBlank(source)) {
            return source;
        }
        StringBuilder buf = null;
        int len = source.length();
        for (int i = 0; i < len; i++) {
            char codePoint = source.charAt(i);
            if (isEmojiCharacter(codePoint)) {
                if (buf == null) {
                    buf = new StringBuilder(source.length());
                }
                buf.append(codePoint);
            }
        }
        if (buf == null) {
            return source;
        } else {
            if (buf.length() == len) {
                buf = null;
                return source;
            } else {
                return buf.toString();
            }
        }
    }

    public static void main(String[] args) {
        /*String str = "·-·\uE40D \uE346";
        System.out.println(EmojiFilter.containsEmoji(string));
        System.out.println(EmojiFilter.filterEmoji(string.trim().toLowerCase().replaceAll(" ","")));
        String str = "An 😀awesome 😃string with a few 😉emojis!";
        String person = EmojiFilter.stringFilter(str);
        person = EmojiParser.removeAllEmojis(person.trim().toLowerCase().replaceAll(" ",""));
        System.out.println(person);*/

        /*String str = "·-·\uE40D \uE346";
        System.out.println(EmojiParser.parseToAliases(str));
        System.out.println(EmojiParser.parseToAliases(str, EmojiParser.FitzpatrickAction.PARSE));
        System.out.println(EmojiParser.parseToAliases(str, EmojiParser.FitzpatrickAction.REMOVE));
        System.out.println(EmojiParser.parseToAliases(str, EmojiParser.FitzpatrickAction.IGNORE));*/

        for (int i = 0;i<10;i++) {
            System.out.println(IDUtils.genImageName());
        }
    }
}
