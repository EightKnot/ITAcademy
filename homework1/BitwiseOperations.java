package HomeWork1;

public class BitwiseOperations {
    public static void main(String[] args) {
        int x = 42, y = 15, z = 0;
        String result = "Результат операции ";

        System.out.println("Входные значения: 42 и 15");

        z = ~x;
        System.out.println(result + "НЕ: " + z);
        /*
 00101010
~
 11010101
         */
        z = ~y;
        System.out.println(result + "НЕ: " + z);
                /*
 00001111
~
 11110000
         */
        z = x & y;
        System.out.println(result + "И: " + z);
        /*
 00101010
&00001111

 00001010
         */
        z = x;
        x &= y;
        System.out.println(result + "И с присваиванием: " + x);
        x = z;
        /*
  00101010
&=00001111

  00001010
         */
        z = x | y;
        System.out.println(result + "ИЛИ: " + z);
        /*
 00101010
|00001111

 00101111
         */
        z = x;
        x |= y;
        System.out.println(result + "ИЛИ с присваиванием: " + x);
        x = z;
        /*
  00101010
|=00001111

  00001010
         */
        z = x ^ y;
        System.out.println(result + "исключающее ИЛИ: " + z);
        /*
 00101010
^00001111

 00100101
         */
        z = x;
        x ^= y;
        System.out.println(result + "исключающее ИЛИ с присваиванием: " + x);
        x = z;
        /*
  00101010
^=00001111

  00100101
         */
        z = x >> 3;
        System.out.println(result + "сдвиг вправо на 3: " + z);
                /*
 00101010
>>3
 00000101
         */
        z = x;
        x >>= 3;
        System.out.println(result + "сдвиг вправо на 3 с присваиванием: " + x);
        x = z;
                /*
 00101010
>>3
 00000101
         */
        z = x >>> 3;
        System.out.println(result + "сдвиг вправо на 3 с заполнением нулями: " + z);
                /*
 00101010
>>3
 00000101
         */ z = x << 4;
        System.out.println(result + "сдвиг влево на 4: " + z);
                /*
 00101010
<<4
 10100000
         */
        z = x;
        x <<= 4;
        System.out.println(result + "сдвиг влево на 4 с присваиванием: " + x);
        x = z;
                /*
 00101010
<<=4
 10100000

         */
        z = x;
        x >>>= 4;
        System.out.println(result + "сдвиг вправо на 4 с заполнением нулями с присваиванием: " + x);
                /*
 00101010
>>>=4
 00000010
         */



        x = -42;
        y = -15;
        z = 0;

        System.out.println("\nВходные значения: -42 и -15");

        z = ~x;
        System.out.println(result + "НЕ: " + z);
        /*
 11010110
~
 00101001
         */
        z = ~y;
        System.out.println(result + "НЕ: " + z);
                /*
 11110001
~
 00001110
         */
        z = x & y;
        System.out.println(result + "И: " + z);
        /*
 11010110
&11110001

 11010000
         */
        z = x;
        x &= y;
        System.out.println(result + "И с присваиванием: " + x);
        x = z;
        /*
  11010110
&=11110001

  11010000
         */
        z = x | y;
        System.out.println(result + "ИЛИ: " + z);
        /*
 11010110
|11110001

 11110111
         */
        z = x;
        x |= y;
        System.out.println(result + "ИЛИ с присваиванием: " + x);
        x = z;
        /*
  11010110
|=11110001

  11110111
         */
        z = x ^ y;
        System.out.println(result + "исключающее ИЛИ: " + z);
        /*
 11010110
^11110001

 00100111
         */
        z = x;
        x ^= y;
        System.out.println(result + "исключающее ИЛИ с присваиванием: " + x);
        x = z;
        /*
  11010110
^=11110001

  00100111
         */
        z = x >> 3;
        System.out.println(result + "сдвиг вправо на 3: " + z);
                /*
 11010110
>>3
 11111010
         */
        z = x;
        x >>= 3;
        System.out.println(result + "сдвиг вправо на 3 с присваиванием: " + x);
        x = z;
                /*
 11010110
>>3
 11111010
         */
        z = x >>> 3;
        System.out.println(result + "сдвиг вправо на 3 с заполнением нулями: " + z);
                /*
 11010110
>>3
 00011010
         */ z = x << 4;
        System.out.println(result + "сдвиг влево на 4: " + z);
                /*
 11010110
<<4
 01100000
         */
        z = x;
        x <<= 4;
        System.out.println(result + "сдвиг влево на 4 с присваиванием: " + x);
        x = z;
                /*
 11010110
<<=4
 01100000

         */
        z = x;
        x >>>= 4;
        System.out.println(result + "сдвиг вправо на 4 с заполнением нулями с присваиванием: " + x);
                /*
 11010110
>>>=4
 00001101
         */
    }

}
