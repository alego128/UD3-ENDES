/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividad_02_ud3_ed;

/**
 * La clase CCuenta representa una cuenta bancaria con atributos como el nombre del titular, el número de cuenta,
 * el saldo y el tipo de interés. Proporciona métodos para gestionar el saldo de la cuenta, así como para ingresar
 * y retirar dinero de la misma.
 * 
 * @author Alego
 */
public class CCuenta {

    /**
     * Nombre del titular de la cuenta.
     */
    protected String nombre;
    
    /**
     * Número de cuenta bancaria.
     */
    private String cuenta;
    
    /**
     * Saldo disponible en la cuenta.
     */
    private double saldo;
    
    /**
     * Tipo de interés de la cuenta.
     */
    private double tipoInterés;

    /**
     * Constructor por defecto de la clase CCuenta.
     * 
     * Este constructor crea una cuenta con los valores predeterminados.
     */
    public CCuenta ()
    {
    }

    /**
     * Constructor de la clase CCuenta.
     * 
     * @param nom Nombre del titular de la cuenta.
     * @param cue Número de cuenta bancaria.
     * @param sal Saldo inicial de la cuenta.
     * @param tipo Tipo de interés de la cuenta.
     */
    public CCuenta (String nom, String cue, double sal, double tipo)
    {
        nombre = nom;
        cuenta = cue;
        saldo = sal;
        tipoInterés = tipo;
    }

    /**
     * Asigna el nombre del titular de la cuenta.
     * 
     * @param nom Nombre del titular de la cuenta.
     */
    public void asignarNombre(String nom)
    {
        nombre = nom;
    }

    /**
     * Obtiene el nombre del titular de la cuenta.
     * 
     * @return El nombre del titular de la cuenta.
     */
    public String obtenerNombre()
    {
        return nombre;
    }

    /**
     * Obtiene el saldo disponible en la cuenta.
     * 
     * @return El saldo de la cuenta.
     */
    public double estado ()
    {
        return saldo;
    }

    /**
     * Ingresa una cantidad de dinero en la cuenta.
     * 
     * @param cantidad La cantidad de dinero a ingresar.
     * @throws Exception Si la cantidad es negativa, lanza una excepción.
     */
    public void ingresar(double cantidad) throws Exception
    {
        if (cantidad < 0) {
            throw new Exception("No se puede ingresar una cantidad negativa");
        }
        setSaldo(saldo + cantidad);
    }

    /**
     * Retira una cantidad de dinero de la cuenta.
     * 
     * @param cantidad La cantidad de dinero a retirar.
     * @throws Exception Si la cantidad es negativa o si no hay suficiente saldo en la cuenta, lanza una excepción.
     */
    public void retirar(double cantidad) throws Exception
    {
        if (cantidad < 0) {
            throw new Exception("No se puede retirar una cantidad negativa");
        }
        if (estado() < cantidad) {
            throw new Exception("No hay suficiente saldo");
        }
        setSaldo(saldo - cantidad);
    }

    /**
     * Obtiene el número de cuenta bancaria.
     * 
     * @return El número de cuenta.
     */
    public String obtenerCuenta()
    {
        return cuenta;
    }

    /**
     * Asigna el número de cuenta bancaria.
     * 
     * @param cuenta El número de cuenta a asignar.
     */
    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    /**
     * Asigna el saldo de la cuenta.
     * 
     * @param saldo El saldo a asignar.
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    /**
     * Obtiene el tipo de interés de la cuenta.
     * 
     * @return El tipo de interés de la cuenta.
     */
    public double getTipoInterés() {
        return tipoInterés;
    }

    /**
     * Asigna el tipo de interés de la cuenta.
     * 
     * @param tipoInterés El tipo de interés a asignar.
     */
    public void setTipoInterés(double tipoInterés) {
        this.tipoInterés = tipoInterés;
    }
}
