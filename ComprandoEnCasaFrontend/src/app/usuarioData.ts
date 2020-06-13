import { ListaDeCompras } from './listaDeCompras';

export interface UsuarioData {
  nombreUsuario: string,
  email: string,
  id: number,
  password: string,
  imagenPerfil:string,
  calle:string,
  localidad:string,
  provincia:string,
  pais:string,
  codigoPostal:number,
  listaDeCompras:ListaDeCompras,
  historialDeCompras:ListaDeCompras[]
}
