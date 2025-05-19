/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1_parcial;

import java.util.Scanner;

public class proyecto_prueba {

    public static void main(String[] args) {
        Scanner lea = new Scanner(System.in);
        lea.useDelimiter("\n");

        String opcion;
        double dinero_caja = 0;
        double dinero_Inicio_Caja;
        boolean caja = false;
        int dia = 1;

        double KgAzucar_Almacenado = 0;
        double KgMaiz_Almacenado = 0;
        double KgTrigo_Almacenado = 0;
        double KgAvenaC_Almacenado = 0;
        double KgAvenaB_Almacenado = 0;
        double kgAvena_Venta_Total;

        int Numero_deCompras = 0;
        int Numero_deVentas = 0;
        double Monto_Total_Compras = 0;
        double Monto_Total_Ventas = 0;
        double Ganancia_Total = 0;

        double KgAzucar_venta_total = 0;
        double KgAvena_venta_total = 0;
        double KgTrigo_venta_total = 0;
        double KgMaiz_venta_total = 0;

        double Promedio_venta = 0;
        double Promedio_Compra = 0;
        String Producto_estrella = "";
        double Producto_estrella_Cantidad = 0;
        double Ganancia_Mayor = 0;
        double Venta_Mayor = 0;
        int Numero_Venta_mayor = 0;
        double Compra_Mayor = 0;
        int Numero_Compra_mayor = 0;

        do {
            do {
                System.out.println("\n**** CAJA REGISTRADORA ****");
                System.out.println("1) Abrir caja (agregar dinero)");
                System.out.println("2) Ventas");
                System.out.println("3) Compras");
                System.out.println("4) Reportes");
                System.out.println("5) Cierre Caja");
                System.out.println("6) Salir del Sistema");
                System.out.print("Elija una de las Opciones: ");
                opcion = lea.next();

                if (!opcion.equals("1") && !opcion.equals("2") && !opcion.equals("3")
                        && !opcion.equals("4") && !opcion.equals("5") && !opcion.equals("6")) {

                    System.out.println("\n-- La opcion es invalida --");
                }
            } while (!opcion.equals("1") && !opcion.equals("2") && !opcion.equals("3")
                    && !opcion.equals("4") && !opcion.equals("5") && !opcion.equals("6"));

            switch (opcion) {
                case "1":
                    if(dinero_caja <= 0){
                    
                    do {
                        System.out.println("\n**Elijiste la opcion de abrir caja**");
                        System.out.println("Dia de trabajo: " + dia);
                        System.out.println("Dinero en la caja: Lps. " + String.format("%.2f", dinero_caja));
                        System.out.println("** Debe ingresar dinero para que la caja se habilite ** ");
                        System.out.println("Ingrese el monto en la caja: ");
                        dinero_Inicio_Caja = lea.nextInt();
                        if (dinero_Inicio_Caja < 0) {
                            System.out.println("-- No puede ingreasar un valor negativo. --");
                        }
                    } while (dinero_Inicio_Caja < 0);

                    dinero_caja += dinero_Inicio_Caja;
                    System.out.println("Dinero en la caja actualizado: Lps. " + String.format("%.2f", dinero_caja));
                    caja = true;
                    }else{
                        String Dineroextra ;
                        do{
                        System.out.println("\n**Elijiste la opcion de abrir caja**");
                        System.out.println("Dia de trabajo: " + dia);
                        System.out.println("Dinero en la caja: Lps. " + String.format("%.2f", dinero_caja));
                        System.out.println("*Desea ingresar dinero (sio no): ");
                        Dineroextra = lea.next().toLowerCase();
                            if(Dineroextra.equals("si")){
                                do{
                                    System.out.println("Ingrese el monto en la caja: ");
                                    dinero_Inicio_Caja = lea.nextInt();
                                    
                                    if (dinero_Inicio_Caja < 0) {
                                        System.out.println("-- No puede ingreasar un valor negativo. --");
                                    }
                                } while (dinero_Inicio_Caja < 0);
                                dinero_caja += dinero_Inicio_Caja;                               
                            }
                        } while (!Dineroextra.equals("si") && !Dineroextra.equals("no"));
                        
                    System.out.println("Dinero en la caja actualizado: Lps. " + String.format("%.2f", dinero_caja));
                    caja = true;
                    }
                    
                    break;
                case "2":

                    //El if sirve para detectar si la caja ya se abrio
                    if (dinero_caja > 0 && caja) {

                        //El if corrobora que haya producto
                        if (KgAzucar_Almacenado > 0 || KgMaiz_Almacenado > 0
                                || KgTrigo_Almacenado > 0 || KgAvenaB_Almacenado > 0 || KgAvenaC_Almacenado > 0) {

                            String cliente;
                            //El do-while sirve para regresar al menu si elige una letra que no es correcta
                            do {
                                System.out.println("\n**Elijiste la opcion de Ventas**");
                                System.out.println("A) Tipo A");
                                System.out.println("B) Tipo B");
                                System.out.println("C) Tipo C");
                                System.out.print("Seleccione el tipo de cliente que es(A/B/C): ");
                                cliente = lea.next().toLowerCase();

                                //el if si elige una letra que no es correcta le imprime un error
                                if (!cliente.equals("a") && !cliente.equals("b") && !cliente.equals("c")) {
                                    System.out.println("\n--- EL TIPO DE CLIENTE ES INCORRECTO ---\n");
                                }

                            } while (!cliente.equals("a") && !cliente.equals("b") && !cliente.equals("c"));

                            String Codigo_producto_Compra = "";
                            double Precio_Venta = 0;
                            double kg_venta;
                            double subtotal;
                            double subtotal_Azucar = 0;
                            double subtotal_Avena = 0;
                            double subtotal_Trigo = 0;
                            double subtotal_Maiz = 0;

                            double KgAzucar_venta = 0;
                            double Kg_Avena_venta = 0;
                            double Kg_Trigo_venta = 0;
                            double Kg_Maiz_venta = 0;
                            double kg_venta_b_restante = KgAvenaB_Almacenado;
                            double kg_restante = 0;

                            String producto_venta = "";
                            int Cantidad_Productos_Azucar = 0;
                            int Cantidad_Productos_Avena = 0;
                            int Cantidad_Productos_Trigo = 0;
                            int Cantidad_Productos_Maiz = 0;

                            String KgAzucar_registro = "";
                            String KgAvena_registro = "";
                            String KgTrigo_registro = "";
                            String KgMaiz_registro = "";
                            String KgAzucar_registro_venta = "";
                            String KgAvena_registro_venta = "";
                            String KgTrigo_registro_venta = "";
                            String KgMaiz_registro_venta = "";
                            String Otro_producto;
                            char seleccion_avena = ' ';

                            //En los if anidados se busca el tipo de cliente que eligio
                            System.out.println("\n** Seleccione el producto que desee vender: **");
                            System.out.println("|_CODIGO__|_PRODUCTO___|_PRECIO_VENTA_|");
                            if (cliente.equals("a")) {

                                //el do-while regresa si elige comprar otra ves un producto
                                do {

                                    //el do-while regresa si ingresa un codigo que no es correcto
                                    do {
                                        System.out.println("|1________|Azucar______|Lps.30________|");
                                        System.out.println("|2________|Avena_______|Lps.25________|");
                                        System.out.println("|3________|Trigo_______|Lps.32________|");
                                        System.out.println("|4________|Maiz________|Lps.20________|");
                                        System.out.print("-Ingrese el codigo del producto que desee Comprar: ");
                                        Codigo_producto_Compra = lea.next();

                                        //El if si elige una codigo que no es correcta lo imprime un error
                                        if (!Codigo_producto_Compra.equals("1") && !Codigo_producto_Compra.equals("2")
                                                && !Codigo_producto_Compra.equals("3") && !Codigo_producto_Compra.equals("4")) {
                                            System.out.println("\n-- EL CODIGO DEL PRODUCTO ES INCORRECTO --\n");
                                        }

                                    } while (!Codigo_producto_Compra.equals("1") && !Codigo_producto_Compra.equals("2")
                                            && !Codigo_producto_Compra.equals("3") && !Codigo_producto_Compra.equals("4"));

                                    //el switch elige los valores segun la eleccion del usuario
                                    switch (Codigo_producto_Compra) {
                                        case "1":
                                            Precio_Venta = 30.00;
                                            producto_venta = "Azucar";
                                            break;
                                        case "2":
                                            Precio_Venta = 25.00;
                                            producto_venta = "Avena";
                                            break;
                                        case "3":
                                            Precio_Venta = 32.00;
                                            producto_venta = "Trigo";
                                            break;
                                        case "4":
                                            Precio_Venta = 20.00;
                                            producto_venta = "Maiz";
                                            break;
                                    }

                                    //Se ingresa la cantidad de kg del producto que desee vender
                                    do {
                                        System.out.println("\n|" + Codigo_producto_Compra + "________|"
                                                + producto_venta + "________|Lps." + Precio_Venta + "________|");
                                        System.out.print("Ingrese la cantidad que desea vender:");
                                        kg_venta = lea.nextDouble();

                                        if (kg_venta < 0) {
                                            System.out.println("-- No puede ingreasar un valor negativo. --");
                                        }

                                    } while (kg_venta < 0);

                                    //Se suma el Subtotal de totas las compras
                                    subtotal = Precio_Venta * kg_venta;

                                    /*
                                    los if anidados verifican si hay Kg de el producto que selecciono
                                    y añade a las variables segun el produco los precios por compra
                                     */
                                    switch (Codigo_producto_Compra) {
                                        case "1":
                                            if (KgAzucar_Almacenado >= kg_venta) {
                                                KgAzucar_Almacenado -= kg_venta;
                                                KgAzucar_venta += kg_venta;
                                                Cantidad_Productos_Azucar++;
                                                subtotal_Azucar += subtotal;
                                                KgAzucar_registro += kg_venta + "/";
                                                KgAzucar_registro_venta += subtotal + "/";
                                            } else {
                                                System.out.println("NO hay suficiente " + producto_venta + " en almacenamineto");
                                            }
                                            break;
                                        case "2":
                                            kgAvena_Venta_Total = KgAvenaB_Almacenado + KgAvenaC_Almacenado;
                                            if (KgAvenaB_Almacenado >= kg_venta) {
                                                KgAvenaB_Almacenado -= kg_venta;
                                                Kg_Avena_venta += kg_venta;
                                                Cantidad_Productos_Avena++;
                                                subtotal_Avena += subtotal;
                                                KgAvena_registro += kg_venta + "/";
                                                KgAvena_registro_venta += subtotal + "/";
                                                seleccion_avena = 'b';
                                            } else if (kgAvena_Venta_Total >= kg_venta) {
                                                kg_venta_b_restante = KgAvenaB_Almacenado;
                                                kg_restante = kg_venta - KgAvenaB_Almacenado;
                                                KgAvenaC_Almacenado -= kg_restante;
                                                KgAvenaB_Almacenado = 0;
                                                Kg_Avena_venta += kg_venta;
                                                Cantidad_Productos_Avena++;
                                                subtotal_Avena += subtotal;
                                                KgAvena_registro += kg_venta + "/";
                                                KgAvena_registro_venta += subtotal + "/";
                                            } else {
                                                System.out.println("NO hay suficiente " + producto_venta + " en almacenamineto");
                                            }
                                            break;
                                        case "3":
                                            if (KgTrigo_Almacenado >= kg_venta) {
                                                KgTrigo_Almacenado -= kg_venta;
                                                Kg_Trigo_venta += kg_venta;
                                                Cantidad_Productos_Trigo++;
                                                subtotal_Trigo += subtotal;
                                                KgTrigo_registro += kg_venta + "/";
                                                KgTrigo_registro_venta += subtotal + "/";
                                            } else {
                                                System.out.println("NO hay suficiente " + producto_venta + " en almacenamineto");
                                            }
                                            break;
                                        case "4":
                                            if (KgMaiz_Almacenado >= kg_venta) {
                                                KgMaiz_Almacenado -= kg_venta;
                                                Kg_Maiz_venta += kg_venta;
                                                Cantidad_Productos_Maiz++;
                                                subtotal_Maiz += subtotal;
                                                KgMaiz_registro += kg_venta + "/";
                                                KgMaiz_registro_venta += subtotal + "/";
                                            } else {
                                                System.out.println("NO hay suficiente " + producto_venta + " en almacenamineto");
                                            }
                                            break;
                                    }

                                    //el do-while regresa si elige comprar otra ves un producto
                                    do {

                                        System.out.print("Desea comprar otro producto(si o no):");
                                        Otro_producto = lea.next().toLowerCase();

                                        if (!Otro_producto.equals("si") && !Otro_producto.equals("no")) {
                                            System.out.println("-- No es valida la respuesta --");
                                        }

                                    } while (!Otro_producto.equals("si") && !Otro_producto.equals("no"));
                                } while (Otro_producto.equals("si"));

                            } else if (cliente.equals("b")) {

                                //el do-while regresa si elige comprar otra ves un producto
                                do {

                                    //el do-while regresa si ingresa un codigo que no es correcto
                                    do {

                                        System.out.println("|1________|Azucar______|Lps.30________|");
                                        System.out.println("|2________|Avena_______|Lps.25________|");
                                        System.out.println("|3________|Trigo_______|Lps.32________|");
                                        System.out.print("-Ingrese el codigo del producto que desee Comprar: ");
                                        Codigo_producto_Compra = lea.next();

                                        //El if si elige una codigo que no es correcta lo imprime un error
                                        if (!Codigo_producto_Compra.equals("1") && !Codigo_producto_Compra.equals("2")
                                                && !Codigo_producto_Compra.equals("3")) {
                                            System.out.println("\n**EL CODIGO DEL PRODUCTO ES INCORRECTO**\n");
                                        }

                                    } while (!Codigo_producto_Compra.equals("1") && !Codigo_producto_Compra.equals("2")
                                            && !Codigo_producto_Compra.equals("3"));

                                    //los if anidados eligen los valores segun la eleccion del usuario 
                                    if (Codigo_producto_Compra.equals("1")) {
                                        Precio_Venta = 30.00;
                                        producto_venta = "Azucar";
                                    } else if (Codigo_producto_Compra.equals("2")) {
                                        Precio_Venta = 25.00;
                                        producto_venta = "Avena";
                                    } else if (Codigo_producto_Compra.equals("3")) {
                                        Precio_Venta = 32.00;
                                        producto_venta = "Trigo";
                                    }

                                    do {
                                        System.out.println("\n|" + Codigo_producto_Compra + "________|"
                                                + producto_venta + "________|Lps." + Precio_Venta + "________|");
                                        System.out.print("Ingrese la cantidad que desea vender:");
                                        kg_venta = lea.nextDouble();

                                        if (kg_venta < 0) {
                                            System.out.println("-- No puede ingreasar un valor negativo. --");
                                        }

                                    } while (kg_venta < 0);

                                    //Se suma el Subtotal de totas las compras
                                    subtotal = Precio_Venta * kg_venta;

                                    /*
                                    los if anidados verifican si hay Kg de el producto que selecciono
                                    y añade a las variables segun el producto los precios por compra
                                     */
                                    if (Codigo_producto_Compra.equals("1")) {

                                        if (KgAzucar_Almacenado >= kg_venta) {
                                            KgAzucar_Almacenado -= kg_venta;
                                            KgAzucar_venta += kg_venta;
                                            Cantidad_Productos_Azucar++;
                                            subtotal_Azucar += subtotal;
                                            KgAzucar_registro += kg_venta + "/";
                                            KgAzucar_registro_venta += subtotal + "/";
                                        } else {
                                            System.out.println("NO hay suficiente " + producto_venta + " en almacenamineto");
                                        }

                                    } else if (Codigo_producto_Compra.equals("2")) {

                                        kgAvena_Venta_Total = KgAvenaB_Almacenado + KgAvenaC_Almacenado;
                                        if (KgAvenaB_Almacenado >= kg_venta) {
                                            KgAvenaB_Almacenado -= kg_venta;
                                            Kg_Avena_venta += kg_venta;
                                            Cantidad_Productos_Avena++;
                                            subtotal_Avena += subtotal;
                                            KgAvena_registro += kg_venta + "/";
                                            KgAvena_registro_venta += subtotal + "/";
                                            seleccion_avena = 'b';
                                        } else if (kgAvena_Venta_Total >= kg_venta) {
                                            kg_venta_b_restante = KgAvenaB_Almacenado;
                                            kg_restante = kg_venta - KgAvenaB_Almacenado;
                                            KgAvenaC_Almacenado -= kg_restante;
                                            KgAvenaB_Almacenado = 0;
                                            Kg_Avena_venta += kg_venta;
                                            Cantidad_Productos_Avena++;
                                            subtotal_Avena += subtotal;
                                            KgAvena_registro += kg_venta + "/";
                                            KgAvena_registro_venta += subtotal + "/";
                                        } else {
                                            System.out.println("NO hay suficiente " + producto_venta + " en almacenamineto");
                                        }

                                    } else if (Codigo_producto_Compra.equals("3")) {

                                        if (KgTrigo_Almacenado >= kg_venta) {
                                            KgTrigo_Almacenado -= kg_venta;
                                            Kg_Trigo_venta += kg_venta;
                                            Cantidad_Productos_Trigo++;
                                            subtotal_Trigo += subtotal;
                                            KgTrigo_registro += kg_venta + "/";
                                            KgTrigo_registro_venta += subtotal + "/";
                                        } else {
                                            System.out.println("NO hay suficiente " + producto_venta + " en almacenamineto");
                                        }

                                    }

                                    //el do-while regresa si elige comprar otra ves un producto
                                    do {
                                        System.out.print("Desea comprar otro producto(si o no):");
                                        Otro_producto = lea.next().toLowerCase();
                                        if (!Otro_producto.equals("si") && !Otro_producto.equals("no")) {
                                            System.out.println("-- No es valida la respuesta --");
                                        }
                                    } while (!Otro_producto.equals("si") && !Otro_producto.equals("no"));

                                } while (Otro_producto.equals("si"));

                            } else if (cliente.equals("c")) {
                                //el do-while regresa si elige comprar otra ves un producto
                                do {
                                    System.out.println("|4________|Maiz________|Lps.20________|");
                                    //El if si elige una codigo que no es el correcta lo imprime un error

                                    Precio_Venta = 20.00;
                                    producto_venta = "Maiz";

                                    do {
                                        System.out.print("Ingrese la cantidad que desea vender:");
                                        kg_venta = lea.nextDouble();
                                        if (kg_venta < 0) {
                                            System.out.println("-- No puede ingreasar un valor negativo. --");
                                        }
                                    } while (kg_venta < 0);

                                    //Se suma el Subtotal de totas las compras
                                    subtotal = Precio_Venta * kg_venta;

                                    /*
                                    el if verifica si hay Kg de el producto
                                    y almacena los valores por compra
                                     */
                                    if (KgMaiz_Almacenado >= kg_venta) {
                                        KgMaiz_Almacenado -= kg_venta;
                                        Kg_Maiz_venta += kg_venta;
                                        Cantidad_Productos_Maiz++;
                                        subtotal_Maiz += subtotal;
                                        KgMaiz_registro += kg_venta + "/";
                                        KgMaiz_registro_venta += subtotal + "/";
                                    } else {
                                        System.out.println("NO hay suficiente " + producto_venta + " en almacenamineto");
                                    }

                                    //el do-while regresa si elige comprar otra ves un producto
                                    do {
                                        System.out.print("Desea comprar otro producto(si o no):");
                                        Otro_producto = lea.next().toLowerCase();
                                        if (!Otro_producto.equals("si") && !Otro_producto.equals("no")) {
                                            System.out.println("-- No es valida la respuesta --");
                                        }
                                    } while (!Otro_producto.equals("si") && !Otro_producto.equals("no"));

                                } while (Otro_producto.equals("si"));
                            }

                            //Descuento
                            //Se declaran las variables del descuento y total
                            double Ganancia_azucar = 0;
                            double Ganancia_avena = 0;
                            double Ganancia_trigo = 0;
                            double Ganancia_maiz = 0;
                            double total;
                            double descuento = 0;
                            double impuesto;

                            subtotal = subtotal_Azucar + subtotal_Avena + subtotal_Trigo + subtotal_Maiz;

                            //Se busca el tipo de descuento 
                            String Tipo_descuento = "DTO: 0% ";
                            if (subtotal >= 1000 && subtotal < 5000) {
                                descuento = subtotal * 0.05;

                                Tipo_descuento = "DTO: 5% ";
                            } else if (subtotal >= 5000) {
                                descuento = subtotal * 0.10;
                                Tipo_descuento = "DTO: 10%";
                            }

                            //Se hace el calculo del impuesto y total
                            impuesto = subtotal * 0.07;
                            total = subtotal - descuento + impuesto;

                            //Facturacion
                            System.out.println("\n          **FACTURA**");
                            System.out.println("          Ciudad: SPS");
                            System.out.println("          Sede: UNITEC");
                            System.out.println("-DETALLES DE LA COMPRA");
                            System.out.println("*Detalles       Precio/Kg     Kg     Monto/producto");

                            //Se imprime en orden los subtotales y los kg por compra de azucar
                            int i_precio = 0;
                            int i_venta = 0;
                            if (subtotal_Azucar > 0) {
                                while (i_venta < KgAzucar_registro.length() && i_precio < KgAzucar_registro_venta.length()) {

                                    // Leer los kilos vendidos como texto
                                    String kg_porventa = "";
                                    while (i_venta < KgAzucar_registro.length() && KgAzucar_registro.charAt(i_venta) != '/') {
                                        kg_porventa += KgAzucar_registro.charAt(i_venta);
                                        i_venta++;
                                    }
                                    i_venta++; // Saltar '/'

                                    // Leer el precio de compra como texto
                                    String precio_compra = "";
                                    while (i_precio < KgAzucar_registro_venta.length() && KgAzucar_registro_venta.charAt(i_precio) != '/') {
                                        precio_compra += KgAzucar_registro_venta.charAt(i_precio);
                                        i_precio++;
                                    }
                                    i_precio++; // Saltar '/'

                                    // Imprimir producto en una línea
                                    System.out.printf("%-15s L.%-11s %-6s L.%-13s\n", "Azucar", "30.00", kg_porventa, precio_compra);
                                }

                                // Imprimir subtotal al final
                                System.out.printf("%-29s %-6.2f L.%-13.2f\n\n", "-Subtotal Azucar ", KgAzucar_venta, subtotal_Azucar);

                                // Se compara el producto estrella
                                KgAzucar_venta_total += KgAzucar_venta;
                                if (Producto_estrella_Cantidad < KgAzucar_venta_total) {
                                    if (Producto_estrella.equals("Azucar")) {
                                        Producto_estrella_Cantidad += KgAzucar_venta_total;
                                    }
                                    Producto_estrella = "Azucar";
                                    Producto_estrella_Cantidad = KgAzucar_venta_total;
                                }

                                //se calcula la ganancia del azucar vendido
                                Ganancia_azucar = subtotal_Azucar - (KgAzucar_venta * 25);
                            }

                            //Se imprime en orden los subtotales y los kg por compra de Avena
                            i_precio = 0;
                            i_venta = 0;
                            if (subtotal_Avena > 0) {
                                while (i_venta < KgAvena_registro.length() && i_precio < KgAvena_registro_venta.length()) {

                                    // Leer los kilos vendidos como texto
                                    String kg_porventa = "";
                                    while (i_venta < KgAvena_registro.length() && KgAvena_registro.charAt(i_venta) != '/') {
                                        kg_porventa += KgAvena_registro.charAt(i_venta);
                                        i_venta++;
                                    }
                                    i_venta++; // Saltar '/'

                                    // Leer el precio de compra como texto
                                    String precio_compra = "";
                                    while (i_precio < KgAvena_registro_venta.length() && KgAvena_registro_venta.charAt(i_precio) != '/') {
                                        precio_compra += KgAvena_registro_venta.charAt(i_precio);
                                        i_precio++;
                                    }
                                    i_precio++; // Saltar '/'

                                    // Imprimir producto en una línea
                                    System.out.printf("%-15s L.%-11s %-6s L.%-13s\n", "Avena", "25.00", kg_porventa, precio_compra);
                                }
                                // Imprimir subtotal al final
                                System.out.printf("%-29s %-6.2f L.%-13.2f\n\n", "-Subtotal Avena ", Kg_Avena_venta, subtotal_Avena);

                                // Se compara el producto estrella
                                KgAvena_venta_total += Kg_Avena_venta;
                                if (Producto_estrella_Cantidad < KgAvena_venta_total) {
                                    if (Producto_estrella.equals("Avena")) {
                                        Producto_estrella_Cantidad += KgAvena_venta_total;
                                    }
                                    Producto_estrella = "Avena";
                                    Producto_estrella_Cantidad = KgAvena_venta_total;
                                }

                                //se calcula la ganancia de la avena vedida
                                if (seleccion_avena == 'b') {
                                    Ganancia_avena += subtotal_Avena - (Kg_Avena_venta * 20);
                                } else {
                                    Ganancia_avena += subtotal_Avena - ((kg_restante * 22) + (kg_venta_b_restante * 20));
                                }
                            }

                            //Se imprime en orden los subtotales y los kg por compra de Trigo
                            i_precio = 0;
                            i_venta = 0;
                            if (subtotal_Trigo > 0) {

                                while (i_venta < KgTrigo_registro.length() && i_precio < KgTrigo_registro_venta.length()) {

                                    // Leer los kilos vendidos como texto
                                    String kg_porventa = "";
                                    while (i_venta < KgTrigo_registro.length() && KgTrigo_registro.charAt(i_venta) != '/') {
                                        kg_porventa += KgTrigo_registro.charAt(i_venta);
                                        i_venta++;
                                    }
                                    i_venta++; // Saltar '/'

                                    // Leer el precio de compra como texto
                                    String precio_compra = "";
                                    while (i_precio < KgTrigo_registro_venta.length() && KgTrigo_registro_venta.charAt(i_precio) != '/') {
                                        precio_compra += KgTrigo_registro_venta.charAt(i_precio);
                                        i_precio++;
                                    }
                                    i_precio++; // Saltar '/'

                                    // Imprimir producto en una línea
                                    System.out.printf("%-15s L.%-11s %-6s L.%-13s\n", "Trigo", "32.00", kg_porventa, precio_compra);
                                }

                                // Imprimir subtotal al final
                                System.out.printf("%-29s %-6.2f L.%-13.2f\n\n", "-Subtotal Trigo ", Kg_Trigo_venta, subtotal_Trigo);

                                // Se compara el producto estrella
                                KgTrigo_venta_total += Kg_Trigo_venta;
                                if (Producto_estrella_Cantidad < KgTrigo_venta_total) {
                                    if (Producto_estrella.equals("Trigo")) {
                                        Producto_estrella_Cantidad += KgTrigo_venta_total;
                                    }
                                    Producto_estrella = "Trigo";
                                    Producto_estrella_Cantidad = KgTrigo_venta_total;
                                }
                                //Se calcula la ganancia del trigo
                                Ganancia_trigo += subtotal_Trigo - (Kg_Avena_venta * 30);

                            }

                            //Se imprime en orden los subtotales y los kg por compra de Maiz
                            i_precio = 0;
                            i_venta = 0;
                            if (subtotal_Maiz > 0) {
                                while (i_venta < KgMaiz_registro.length() && i_precio < KgMaiz_registro_venta.length()) {

                                    // Leer los kilos vendidos como texto
                                    String kg_porventa = "";
                                    while (i_venta < KgMaiz_registro.length() && KgMaiz_registro.charAt(i_venta) != '/') {
                                        kg_porventa += KgMaiz_registro.charAt(i_venta);
                                        i_venta++;
                                    }
                                    i_venta++; // Saltar '/'

                                    // Leer el precio de compra como texto
                                    String precio_compra = "";
                                    while (i_precio < KgMaiz_registro_venta.length() && KgMaiz_registro_venta.charAt(i_precio) != '/') {
                                        precio_compra += KgMaiz_registro_venta.charAt(i_precio);
                                        i_precio++;
                                    }
                                    i_precio++; // Saltar '/'

                                    // Imprimir producto en una línea
                                    System.out.printf("%-15s L.%-11s %-6s L.%-13s\n", "Maiz", "20.00", kg_porventa, precio_compra);
                                }

                                // Imprimir subtotal al final
                                System.out.printf("%-29s %-6.2f L.%-13.2f\n\n", "-Subtotal Maiz ", Kg_Maiz_venta, subtotal_Maiz);

                                // Se compara el producto estrella
                                KgMaiz_venta_total += Kg_Maiz_venta;
                                if (Producto_estrella_Cantidad < KgMaiz_venta_total) {
                                    if (Producto_estrella.equals("Maiz")) {
                                        Producto_estrella_Cantidad += KgMaiz_venta_total;
                                    }
                                    Producto_estrella = "Maiz";
                                    Producto_estrella_Cantidad = KgMaiz_venta_total;
                                }

                                //se calcula la ganancia del maiz vendido
                                Ganancia_maiz += subtotal_Maiz - (Kg_Maiz_venta * 18);

                                Ganancia_Total += Ganancia_maiz;
                            }
                            //Se imprime los subtotales
                            System.out.println("\n-SUBTOTAL                            Lps " + String.format("%.2f", subtotal));
                            System.out.println("-DESCUENTO                  " + Tipo_descuento + " Lps " + String.format("%.2f", descuento));
                            System.out.println("-IMPUESTO                   IMP: 7%  Lps " + String.format("%.2f", impuesto));
                            System.out.println("-TOTAL                               Lps " + String.format("%.2f", total));

                            dinero_caja += subtotal;

                            //Conteo de ventas y suma de totas las ventas
                            Monto_Total_Ventas += subtotal;
                            Numero_deVentas += 1;

                            //Se calcula el Promedio
                            Promedio_venta = Monto_Total_Ventas / Numero_deVentas;

                            //Se calcula la mayor venta
                            if (Venta_Mayor < total) {
                                Venta_Mayor = total;
                                Numero_Venta_mayor = Numero_deVentas;
                            }
                            double Ganancia = Ganancia_azucar + Ganancia_avena + Ganancia_trigo + Ganancia_maiz;
                            if (Ganancia > Ganancia_Mayor) {
                                Ganancia_Mayor = Ganancia;
                            }
                            Ganancia_Total += Ganancia;
                        } else {
                            //Si hay Kg de ningun producto se presente un mensaje
                            System.out.println("\n-- NO HAY KG de PRODUCTOS ALMACENADOS PARA VENDER --");
                        }
                        //Si na abierto la caja se presente un mensaje  
                    } else {
                        System.out.println("\n-- Debe abrir la caja primero --");
                    }

                    break;
                case "3":
                    //El if sirve para detectar si la caja ya se abrio
                    if (dinero_caja > 0 && caja) {

                        //Se declara la variable provedor y se selecciona el tipo de provedor en el menu
                        String provedor;

                        do {
                            System.out.println("\n**Elijiste la opcion de Compras**");
                            System.out.println("A) Tipo A");
                            System.out.println("B) Tipo B");
                            System.out.println("C) Tipo C");
                            System.out.print("Seleccione el tipo de Provedor(A/B/C): ");
                            provedor = lea.next().toLowerCase();
                            //el if si elige una letra que no es correcta le imprime un error
                            if (!provedor.equals("a") && !provedor.equals("b") && !provedor.equals("c")) {
                                System.out.println("Tipo de proveedor no válido. Intente de nuevo.\n");
                            }
                        } while (!provedor.equals("a") && !provedor.equals("b") && !provedor.equals("c"));

                        //Se declaran las variables que se utilizan
                        String Producto_vender;
                        String producto = "";
                        double Kg_producto = 0;
                        double total_Compra = 0;
                        double Precio_producto = 0;

                        System.out.println("\n|_CODIGO__|_PRODUCTO___|_PRECIO_COMPRA__|");
                        //En los if anidados se busca el tipo de provedor que eligio
                        if (provedor.equals("a")) {

                            //el do-while regresa si ingresa el codigo que no es correcto
                            do {
                                System.out.print("|1________|Azucar______|Lps.25__________|");
                                System.out.print("\n|4________|Maiz________|Lps.18__________|\n");
                                System.out.print("-Ingrese el codigo del producto que desee Vender: ");
                                Producto_vender = lea.next();

                                //el if si elige un codigo que no es correcta le imprime un error
                                if (!Producto_vender.equals("1") && !Producto_vender.equals("4")) {
                                    System.out.println("Codigo ingresado no valido, intente de nuevo.\n");
                                }
                            } while (!Producto_vender.equals("1") && !Producto_vender.equals("4"));

                            //Asigna los valores del producto segun la variable
                            if (Producto_vender.equals("1")) {
                                producto = "Azucar";
                                Precio_producto = 25;
                            } else if (Producto_vender.equals("4")) {
                                producto = "Maiz";
                                Precio_producto = 18;
                            }

                            //Se ingresa los Kg y sw intwnta que no ingrese nuemros negativo
                            do {
                                System.out.print("-Ingrese la cantidad de Kg " + producto + " que desee Vender: ");
                                Kg_producto = lea.nextDouble();
                                if (Kg_producto < 0) {
                                    System.out.println("-- No puede ingreasar un valor negativo. --");
                                }
                            } while (Kg_producto < 0);

                            //Calcula el total de la compra
                            total_Compra = Kg_producto * Precio_producto;
                        } else if (provedor.equals("b")) {

                            //el do-while regresa si ingresa el codigo que no es correcto
                            do {
                                System.out.print("|2________|Avena_______|Lps.20__________|");
                                System.out.print("\n|3________|Trigo_______|Lps.30__________|\n");
                                System.out.print("-Ingrese el codigo del producto que desee Vender: ");
                                Producto_vender = lea.next();

                                //el if si elige un codigo que no es correcta le imprime un error
                                if (!Producto_vender.equals("2") && !Producto_vender.equals("3")) {
                                    System.out.println("Codigo ingresado no valido, intente de nuevo.\n");
                                }
                            } while (!Producto_vender.equals("2") && !Producto_vender.equals("3"));

                            //Asigna los valores del producto segun la variable
                            if (Producto_vender.equals("2")) {
                                producto = "Avena";
                                Precio_producto = 20;
                            } else if (Producto_vender.equals("3")) {
                                producto = "Trigo";
                                Precio_producto = 30;
                            }

                            //Se ingresa los Kg y sw intwnta que no ingrese nuemros negativo
                            do {
                                System.out.print("-Ingrese la cantidad de Kg " + producto + " que desee Vender: ");
                                Kg_producto = lea.nextDouble();
                                if (Kg_producto < 0) {
                                    System.out.println("-- No puede ingreasar un valor negativo. --");
                                }
                            } while (Kg_producto < 0);

                            //Calcula el total de la compra
                            total_Compra = Kg_producto * Precio_producto;
                        } else if (provedor.equals("c")) {

                            System.out.print("|2________|Avena_______|Lps.22__________|\n");

                            //Se asigna los valores a la variable 
                            producto = "Avena";
                            Precio_producto = 22;
                            //Se ingresa los Kg y sw intwnta que no ingrese nuemros negativo
                            do {
                                System.out.print("-Ingrese la cantidad de Kg " + producto + " que desee Vender: ");
                                Kg_producto = lea.nextDouble();
                                if (Kg_producto < 0) {
                                    System.out.println("-- No puede ingreasar un valor negativo. --");
                                }
                            } while (Kg_producto < 0);

                            //Calcula el total de la compra
                            total_Compra = Kg_producto * 22;
                        }

                        //Facturacion de Compra
                        //La condicion se realiza la factura del la compra si hay dinero suficiente en caja
                        if (dinero_caja >= total_Compra) {
                            dinero_caja -= total_Compra;
                            System.out.println("\n       **FACTURA-COMPRA**");
                            System.out.println("          Ciudad: SPS");
                            System.out.println("          Sede: UNITEC");
                            System.out.println("-DETALLES DE LA COMPRA");
                            System.out.println("*Descripcion        Kg    Monto/kg");
                            System.out.printf("%-19s %-5.1f L.%.2f\n", producto, Kg_producto, Precio_producto);
                            System.out.println("\n-Total                    L." + String.format("%.2f", total_Compra));

                            //Revisa si hay dinero para compra Kg
                            if (producto.equals("Azucar")) {
                                KgAzucar_Almacenado += Kg_producto;
                            } else if (producto.equals("Maiz")) {
                                KgMaiz_Almacenado += Kg_producto;
                            } else if (producto.equals("Trigo")) {
                                KgTrigo_Almacenado += +Kg_producto;
                            } else if (producto.equals("Avena") && provedor.equals("b")) {
                                KgAvenaB_Almacenado += Kg_producto;
                            } else if (producto.equals("Avena") && provedor.equals("c")) {
                                KgAvenaC_Almacenado += Kg_producto;
                            }

                            Monto_Total_Compras += total_Compra;
                            Numero_deCompras += 1;
                            //promedio
                            Promedio_Compra = Monto_Total_Compras / Numero_deCompras;
                            //Si no se abierto la caja se presenta un mensaje de error  
                            if (Compra_Mayor < total_Compra) {
                                Compra_Mayor = total_Compra;
                                Numero_Compra_mayor = Numero_deCompras;
                            }
                        } else {
                            System.out.println("-- NO SE PUEDE PAGAR COMPRA. --");
                        }

                    } else {
                        System.out.println("\n-- Debe abrir la caja primero --");
                    }

                    break;

                case "4":
                    if (dinero_caja > 0 && caja) {
                        //REPORTES
                        System.out.printf("\n%-70s | Cantidades |\n", "|                             ** Reportes **");
                        System.out.printf("%-70s |L.%-10.2f|\n", "|*Cantidad actual en caja:", dinero_caja);
                        System.out.printf("%-70s |%-12d|\n", "|*Ventas realizadas en el dia (sin ISV):", Numero_deVentas);
                        System.out.printf("%-70s |%-12d|\n", "|*Compras realizadas en el dia:", Numero_deCompras);

                        System.out.println("|*Volumen total de Compras y Ventas efectuadas:");
                        System.out.printf("%-70s |L.%-10.2f|\n", "| -Ventas (sin ISV):", Monto_Total_Ventas);
                        System.out.printf("%-70s |L.%-10.2f|\n", "| -Compras:", Monto_Total_Compras);
                        System.out.printf("%-70s |L.%-10.2f|\n", "| -Ganancia:", Ganancia_Total);

                        System.out.printf("%-70s |L.%-10.2f|\n", "|*Promedio de Venta (sin ISV):", Promedio_venta);
                        System.out.printf("%-70s |L.%-10.2f|\n", "|*Promedio de Compra:", Promedio_Compra);

                        System.out.printf("%s %d con (sin ISV): %7s%-10.2f|\n", "|*La venta con mayor ganancia realizada fue la N.", Numero_Venta_mayor, "|L.", Ganancia_Mayor);
                        System.out.printf("%s %d con: %30s%-10.2f|\n", "|*La Compra con mas gastos fue la N.", Numero_Compra_mayor, "|L.", Compra_Mayor);

                        System.out.printf("%s %-6s con: %34cKg%-10.2f|\n", "|*El producto estrella es", Producto_estrella, '|', Producto_estrella_Cantidad);
                    } else {
                        System.out.println("\n-- Debe abrir la caja primero --");
                    }
                    break;

                case "5":
                    if (dinero_caja > 0 && caja) {

                        System.out.println("\n** Cierre de caja **");

                        // Mostrar el dinero en caja
                        System.out.printf("Dinero final en caja: Lps. %.2f\n", dinero_caja);

                        // Calcular y mostrar el 60% del dinero como monto máximo para depósito
                        double dinero_60 = dinero_caja * 0.60;
                        System.out.printf("Puede depositar máximo hasta el 60%% del dinero en caja: Lps. %.2f\n", dinero_60);

                        double deposito;

                        // Solicitar monto a depositar con validaciones
                        do {
                            System.out.print("Ingrese la cantidad a depositar en el banco: Lps. ");
                            deposito = lea.nextDouble();

                            if (deposito < 0 || deposito > dinero_60) {
                                System.out.println("-- Solo puede depositar hasta el 60% del efectivo en caja --");
                            }

                        } while (deposito < 0 || deposito > dinero_60);

                        // Restar el depósito del dinero en caja
                        dinero_caja -= deposito;
                        System.out.printf("Cantidad que queda en caja para el siguiente día: Lps. %.2f\n", dinero_caja);

                        // Marcar caja como cerrada y avanzar el día
                        caja = false;
                        dia++;

                        // Reiniciar variables de inventario y estadísticas
                        KgAzucar_Almacenado = 0;
                        KgMaiz_Almacenado = 0;
                        KgTrigo_Almacenado = 0;
                        KgAvenaB_Almacenado = 0;
                        KgAvenaC_Almacenado = 0;
                        kgAvena_Venta_Total = 0;

                        Numero_deCompras = 0;
                        Numero_deVentas = 0;
                        Monto_Total_Compras = 0;
                        Monto_Total_Ventas = 0;
                        Ganancia_Total = 0;

                        KgAzucar_venta_total = 0;
                        KgAvena_venta_total = 0;
                        KgTrigo_venta_total = 0;
                        KgMaiz_venta_total = 0;
                        
                        Promedio_venta=0;
                        Promedio_Compra=0;
                        Ganancia_Mayor=0;
                        Compra_Mayor=0;
                        Numero_Venta_mayor=0;
                        Numero_Compra_mayor=0;
                        Producto_estrella=" ";
                        Producto_estrella_Cantidad=0;
                        
                        System.out.println("Caja cerrada");

                    } else {
                        System.out.println("\n-- La caja ya está cerrada. --");
                    }

                    break;
                case "6":
                    //Se sale del sistrema
                    System.out.println("Salida del sistema");
            }

        } while (!opcion.equals("6"));
    }
}
