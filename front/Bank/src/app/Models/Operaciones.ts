export interface Operaciones{
    id:number;
    tipo_transfer: String;
    fecha_transfer: String;
    saldo_in: number;
    saldo_fin: number;
    monto: number;
    mov_financiero: String;
    id_cuenta: number;
    id_cuenta_destino: number;
}