import { Producto } from './producto';

export interface ListaDeCompras {
  id:number,
  productosAcumulados: Producto[],
  montoAcumulado: number
}
