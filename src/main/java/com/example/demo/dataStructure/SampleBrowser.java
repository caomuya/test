package com.example.demo.dataStructure;




/**
 * 实现浏览器的前近后退
 * @author caomuya
 */
public class SampleBrowser {


    public static void main(String[] args) {
        SampleBrowser browser = new SampleBrowser();
        browser.open("http://www.baidu.com");
        browser.open("http://news.baidu.com/");
        browser.open("http://news.baidu.com/ent");
        browser.goBack();
        browser.goBack();
        browser.goForward();
        browser.open("http://www.qq.com");
        browser.goForward();
        browser.goBack();
        browser.goForward();
        browser.goBack();
        browser.goBack();
        browser.goBack();
        browser.goBack();
        browser.checkCurrentPage();
    }


    private String currentPage;
    private LinkedListBasedStack basedStack;
    private LinkedListBasedStack forwardStack;

    public SampleBrowser() {
        this.basedStack = new LinkedListBasedStack();
        this.forwardStack = new LinkedListBasedStack();
    }

    public void open(String url){
        if(this.currentPage != null){
            this.basedStack.push(this.currentPage);
            this.forwardStack.clear();
        }
        showUrl(url,"open");
    }

    public boolean canGoBack(){
        return this.basedStack.size>0;
    }

    public boolean canGoForward(){
        return this.forwardStack.size>0;
    }


    public String goBack(){
        if(this.canGoBack()){
            this.forwardStack.push(this.currentPage);
            String pop = this.basedStack.pop();
            showUrl(pop,"Back");
            return pop;
        }
        System.out.println("* Cannot go back, no pages behind.");
        return null;
    }

    public String goForward(){
        if(this.canGoForward()){
            this.basedStack.push(this.currentPage);
            String pop = this.forwardStack.pop();
            showUrl(pop,"Forward");
            return pop;
        }
        System.out.println("* Cannot go forward, no pages behind.");
        return null;
    }

    public void checkCurrentPage(){
        System.out.println("Current Page is"+ this.currentPage);
    }


    public void showUrl(String url, String prefix) {
        this.currentPage = url;
        System.out.println(prefix + " page == " + url);
    }
    public static class LinkedListBasedStack{

        private int size;
        private Node top;

        static Node createNode(String data,Node next){
            return new Node(data,next);
        }

        public void clear(){
            this.top = null;
            this.size = 0;
        }

        public void push(String data){
            Node node = createNode(data,this.top);
            this.top = node;
            this.size++;
        }

        public String pop(){
            Node popNode = this.top;
            if(popNode == null){
                System.out.println("Stack is empty.");
                return null;
            }
            this.top = this.top.next;
            if(this.size > 0){
                this.size--;
            }

            return popNode.data;

        }

        public String getTopDate(){
            if(this.top == null){
                return null;
            }
            return this.top.data;
        }

        public int getSize() {
            return size;
        }

        public void print(){
            System.out.println("print stack.");
            Node p = this.top;
            while (p != null){
                String data = p.getData();
                System.out.print(data +"\t");
                p=p.next;
            }
            System.out.println();
        }

        public static class Node {

            private String data;
            private Node next;

            public Node(String data) {
                this(data, null);
            }

            public Node(String data, Node next) {
                this.data = data;
                this.next = next;
            }

            public void setData(String data) {
                this.data = data;
            }

            public String getData() {
                return this.data;
            }

            public void setNext(Node next) {
                this.next = next;
            }

            public Node getNext() {
                return this.next;
            }
        }
    }

}
