void main() {
    int cantidadsuma = 0 , SumaTotal = 0, Respuesta = 0, cantidadresta = 0, RestaTotal = 0, cantidadmultiplicacion = 0, MultiplicacionTotal = 1, cantidaddivision = 0, cociente = 0;
    while (true) {
       try {
           Respuesta = Integer.parseInt(IO.readln("\n1: Suma \n2: Resta \n3: Multiplicación \n4: División \n5: Salir\n \n¿Que calculo quieres hacer?\n").replaceAll("\\n" , ""));
           if (Respuesta == 1) {

               while (true) {
                   try {
                       cantidadsuma = Integer.parseInt(IO.readln("\n¿Cuántos numeros quieres sumar?\n").replaceAll("\\n" , ""));
                       break;
                   }catch (NumberFormatException e) {
                       IO.println("FORMATO NO VALIDO, INTRODUCE UN NÚMERO, INTENTALO DE NUEVO");
                   }
               }
               IO.println("\nIntroduce los numeros que quieres sumar:\n");

               for (int i = 1; i <= cantidadsuma; i++ ) {

                   while (true) {
                       try {
                           int numeros = Integer.parseInt(IO.readln().replaceAll("\\n", ""));
                           SumaTotal = SumaTotal + numeros;
                           break;
                       }catch (NumberFormatException e) {
                           IO.println("FORMATO NO VALIDO, INTRODUCE UN NÚMERO, INTENTALO DE NUEVO");
                       }
                   }
               }
               IO.println("\nEl resultado de la suma es: " + SumaTotal);
           }else if (Respuesta == 2) {

               while (true) {
                   try {
                       cantidadresta = Integer.parseInt(IO.readln("\n¿Cuántos numeros quieres restar?\n").replaceAll("\\n" , ""));
                       break;
                   }catch (NumberFormatException e) {
                       IO.println("FORMATO NO VALIDO, INTRODUCE UN NÚMERO, INTENTALO DE NUEVO");
                   }
               }
               IO.println("\nIntroduce los numeros que quieres restar:\n");
               for (int i = 1; i <= cantidadresta; i++ ) {

                   while (true) {
                       try {
                           int numeros = Integer.parseInt(IO.readln().replaceAll("\\n", ""));
                           RestaTotal =  numeros - RestaTotal ;
                           break;
                       }catch (NumberFormatException e) {
                           IO.println("FORMATO NO VALIDO, INTRODUCE UN NÚMERO, INTENTALO DE NUEVO");
                       }
                   }
               }
               IO.println("\nEl resultado de la resta es: " + RestaTotal);
           }else if (Respuesta == 3) {

               while (true) {
                   try {
                       cantidadmultiplicacion = Integer.parseInt(IO.readln("\n¿Cuántos numeros quieres multiplicar?\n").replaceAll("\\n" , ""));
                       break;
                   }catch (NumberFormatException e) {
                       IO.println("FORMATO NO VALIDO, INTRODUCE UN NÚMERO, INTENTALO DE NUEVO");
                   }
               }
               IO.println("\nIntroduce los numeros que quieres multiplicar:\n");
               for (int i = 1; i <= cantidadmultiplicacion; i++ ) {

                   while (true) {
                       try {
                           int numeros = Integer.parseInt(IO.readln().replaceAll("\\n", ""));
                           MultiplicacionTotal =  numeros * MultiplicacionTotal ;
                           break;
                       }catch (NumberFormatException e) {
                           IO.println("FORMATO NO VALIDO, INTRODUCE UN NÚMERO, INTENTALO DE NUEVO");
                       }
                   }
               }

               IO.println("\nEl resultado de la multiplicación es: " + MultiplicacionTotal);
           }else if (Respuesta == 4) {

                   while (true) {
                       try {
                           int dividendo = Integer.parseInt(IO.readln("\nIntroduce el dividendo\n").replaceAll("\\s", ""));
                           while (true) {
                               try {
                                   int divisor = Integer.parseInt(IO.readln("\nIntroduce el divisor\n").replaceAll("\\s" , ""));
                                   cociente = dividendo / divisor;
                                   break;
                               }catch (ArithmeticException e) {
                                   IO.println("\nNO PUEDES DIVIDIR ENTRE 0, INTENTALO DE NUEVO.\n");
                               }
                           }
                           break;
                       }catch (NumberFormatException e) {
                           IO.println("\nFORMATO NO VALIDO, INTRODUCE UN NÚMERO, INTENTALO DE NUEVO\n");
                       }
                   }
               IO.println("\nEl resultado de la división es: " + cociente);
           }else if (Respuesta == 5){
               IO.println("HASTA LA PROXIMAAAAA");
               return;
           }else {
               IO.println("TIENES QUE INTRODUCIR UN NUMERO DEL 1-5, INTENTALO DE NUEVO");
               continue;
           }
           continue;
       } catch (NumberFormatException e) {
           IO.println("FORMATO NO VÁLIDO, INTRODUCE UN NUMERO");
       }
    }
}