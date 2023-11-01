package sem4.task03;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/*
 Создайте телефонный справочник с помощью Map - телефон это ключ,
  а имя значение
 Найдите человека с самым маленьким номером телефона
 Найдите номер телефона человека чье имя самое большое
 в алфавитном порядке
 */
public class Main {
    public static void main(String[] args) {
        Map<String,String> telephonNum = new HashMap<>();
        telephonNum.put("89604567645","Vasya");
        telephonNum.put("89614567640","Petya");
        telephonNum.put("79624567545","Kolya");
        telephonNum.put("89634567040","Masha");
        telephonNum.put("89644567142","Nadya");
        telephonNum.put("89624577625","Petro");
        telephonNum.put("8966224577625","Nikkilock");
        telephonNum.put("965896","Mik");

        var minNumber = telephonNum.entrySet().stream()
                .min(Comparator.comparing(e -> e.getKey())).get();

        System.out.printf("Номер: %s  Имя: %s", minNumber.getKey(),minNumber.getValue());
        System.out.println();

        var maxName = telephonNum.entrySet().stream()
                .max(Comparator.comparing(e -> e.getValue().length())).get();

        System.out.printf("Номер: %s  Имя: %s", maxName.getKey(),maxName.getValue());
    }
}
