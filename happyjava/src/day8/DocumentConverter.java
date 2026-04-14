package day8;

abstract class DocumentConverter {
    abstract String convert(String content);
    public void print(String content) {
        System.out.println(content);
    }
}

class HtmlConverter extends DocumentConverter {

    @Override
    String convert(String content) {
        return "<p>" + content + "</p>";
    }

}


class MarkdownConverter extends DocumentConverter {

    @Override
    String convert(String content) {
        return "**" + content + "**";
    }

}