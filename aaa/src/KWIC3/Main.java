package KWIC3;

public class Main {
    public static void main(String[] args) {
        //��������
        KWICSubject kwicSubject = new KWICSubject();
        //�����۲���
        Input input = new Input("C:\\Users\\sjj\\Desktop\\input.txt");
        Shift shift = new Shift(input.getLineTxt());
        Alphabetizer alphabetizer = new Alphabetizer(shift.getKwicList());
        Output output = new Output(alphabetizer.getKwicList(), "C:\\Users\\sjj\\Desktop\\output.txt");

        // ���۲��߼�������
        kwicSubject.addObserver(input);
        kwicSubject.addObserver(shift);
        kwicSubject.addObserver(alphabetizer);
        kwicSubject.addObserver(output);
        // �𲽵��ø����۲���
        kwicSubject.startKWIC();
    }
}

