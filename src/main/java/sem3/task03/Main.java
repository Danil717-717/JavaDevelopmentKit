package sem3.task03;

/*
 Написать итератор по массиву. Итератор – это объект,
 осуществляющий движение по коллекциям любого типа,
  содержащим любые типы данных. Итераторы обычно имеют только
 два метода – проверка на наличие следующего элемента
  и переход к следующему элементу. Но также, особенно в
  других языках программирования, возможно встретить итераторы,
  реализующие дополнительную логику.
 */
public class Main {
    public static void main(String[] args) {
        Task03<Integer> task03 = new Task03<>(new Integer[]{1,2,3,4});


        for (Integer item: task03) {
            System.out.println(item);
        }
    }
}
