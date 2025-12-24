void main() {
    int opcion = 0, CantidadSuma, NumerosSuma, ResultadoSuma = 0, CantidadResta, NumerosResta, ResultadoResta = 0, CantidadMulti, NumerosMulti, ResultadoMulti = 1, dividendo, divisor = 0, cociente;

    while (true) {
        try {
           opcion = Integer.parseInt(IO.readln("\n1: Suma \n2: Resta \n3: Multiplicación \n4: División \n5: Salir\n \n¿Qué opción quieres?\n").replaceAll("\\s" , ""));
           switch (opcion) {
               case 1:

                   while (true) {
                       try {
                           CantidadSuma = Integer.parseInt(IO.readln("\n¿Cuántos números quieres sumar?\n").replaceAll("\\s" , ""));
                           break;
                       }catch (NumberFormatException e) {
                           IO.println("\nFORMATO NO VÁLIDO, DEBES DE INTRODCIR UN NÚMERO, INTENTALO DE NUEVO\n");
                       }
                   }

                   IO.println("\nIntroduce los números que quieres sumar:\n");
                   for (int i = 1; i <= CantidadSuma; i++) {

                       while (true) {
                           try {
                               NumerosSuma = Integer.parseInt(IO.readln().replaceAll("\\s", ""));
                               ResultadoSuma = ResultadoSuma + NumerosSuma;
                               break;
                           }catch(NumberFormatException e) {
                               IO.println("\nFORMATO NO VÁLIDO, DEBES DE INTRODCIR UN NÚMERO, INTENTALO DE NUEVO\n");
                           }
                       }
                   }
                   IO.println("\nEl resultado de la suma es:" + ResultadoSuma + "\n");
                   ResultadoSuma= 0;
                continue;
               case 2:

                   while (true) {
                       try {
                          CantidadResta = Integer.parseInt(IO.readln("\n¿Cuántos números quieres restar?\n").replaceAll("\\s" , ""));
                          break;
                       }catch (NumberFormatException e) {
                           IO.println("\nFORMATO NO VÁLIDO, DEBES DE INTRODCIR UN NÚMERO, INTENTALO DE NUEVO\n");
                       }
                   }

               IO.println("\nIntroduce los números que quieres restar:\n");
               for (int i = 1; i <= CantidadResta; i++) {
                   while (true) {
                       try {
                           NumerosResta = Integer.parseInt(IO.readln().replaceAll("\\s" , ""));
                           ResultadoResta = NumerosResta - ResultadoResta;
                           break;
                       }catch (NumberFormatException e) {
                           IO.println("\nFORMATO NO VÁLIDO, DEBES DE INTRODCIR UN NÚMERO, INTENTALO DE NUEVO\n");
                       }
                   }
               }
               IO.println("\nEl resultado de la resta es:" + ResultadoResta + "\n");
               ResultadoResta = 0;
               continue;

               case 3:
                   while (true) {
                       try {
                           CantidadMulti = Integer.parseInt(IO.readln("\n¿Cuántos números quieres multiplicar?\n").replaceAll("\\s" , ""));
                           break;
                       }catch (NumberFormatException e) {
                           IO.println("\nFORMATO NO VÁLIDO, DEBES DE INTRODCIR UN NÚMERO, INTENTALO DE NUEVO\n");
                       }
                   }
                   IO.println("\nIntroduce los números que quieres multiplicar: \n");
                   for (int i = 1; i <= CantidadMulti; i++) {
                       while (true) {
                           try {
                                NumerosMulti = Integer.parseInt(IO.readln().replaceAll("\\s" , ""));
                                ResultadoMulti = ResultadoMulti * NumerosMulti;
                                break;
                           }catch (NumberFormatException e) {
                               IO.println("\nFORMATO NO VÁLIDO, DEBES DE INTRODCIR UN NÚMERO, INTENTALO DE NUEVO\n");
                           }
                       }
                   }
                   IO.println("\nEl resultado de la multiplicación es:" + ResultadoMulti + "\n");
                   //ResultadoMulti = 0;
                   continue;
               case 4:
                   while (true) {
                       try {
                           dividendo = Integer.parseInt(IO.readln("\nIntroduce el dividendo: \n").replaceAll("\\s" , ""));
                           break;
                       }catch (NumberFormatException e) {
                           IO.println("\nFORMATO NO VÁLIDO, DEBES INTRODUCIR UN NÚMERO, INTENTALO DE NUEVO\n");
                       }
                   }

                   while (true) {
                       try {
                           divisor = Integer.parseInt(IO.readln("\nIntroduce el divisor: \n").replaceAll("\\s" , "") );
                           if (divisor == 0) {
                               IO.println("\nNO ES POSIBLE DIVIDIR ENTRE O, INTRODUCE OTRO NÚMERO.\n");
                               continue;
                           }
                           break;
                       }catch (NumberFormatException e) {
                           IO.println("\nFORMATO NO VÁLIDO, DEBES INTRODUCIR UN NÚMERO, INTENTALO DE NUEVO\n");
                       }
                   }
                   cociente = dividendo /divisor;
                   IO.println("\nEl resultado es:" + cociente + "\n");
                   continue;
               case 5:
                   IO.println("\nHASTA LA PROXIMA\n");
                   return;
               default:
                   IO.println("\nTIENES QUE INTRODUCIR UN NÚMERO DEL 1-5, INTENTALO DE NUEVO\n");
           }
           continue;
        }catch (NumberFormatException e) {
            IO.println("\nFORMATO NO VÁLIDO, DEBES DE INTRODCIR UN NÚMERO, INTENTALO DE NUEVO\n");
        }
    }
}