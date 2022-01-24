import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddCuentaComponent } from './Cuenta/add-cuenta/add-cuenta.component';
import { ListarCuentaComponent } from './Cuenta/listar-cuenta/listar-cuenta.component';
import { ConsignacionComponent } from './Operaciones/consignacion/consignacion.component';
import { ListarOperacionesComponent } from './Operaciones/listar-operaciones/listar-operaciones.component';
import { RetiroComponent } from './Operaciones/retiro/retiro.component';
import { TransferenciaComponent } from './Operaciones/transferencia/transferencia.component';
import { AddUsuarioComponent } from './Usuario/add-usuario/add-usuario.component';
import { DeleterUsuarioComponent } from './Usuario/deleter-usuario/deleter-usuario.component';
import { EditUsuarioComponent } from './Usuario/edit-usuario/edit-usuario.component';
import { ListarUsuarioComponent } from './Usuario/listar-usuario/listar-usuario.component';

const routes: Routes = [
  // listar usuarios
  {path:'listar', component:ListarUsuarioComponent},
  // agregar usuario
  {path:'add', component:AddUsuarioComponent},
  // editar usuario
  {path:'edit/:id', component:EditUsuarioComponent},
  // eliminar usuario
  {path:'delete', component:DeleterUsuarioComponent},
  // listar cuentas
  {path: 'listarCuentas/:id', component:ListarCuentaComponent},
  // nueva cuenta agregar
  {path: 'addCuenta/:id', component:AddCuentaComponent},
  // listar operaciones
  //{path: 'listarCuentas/:id/transactions/:id', component:ListarOperaciones}
  {path: 'listarOperaciones/:id', component:ListarOperacionesComponent},
  //operacion retiro
  {path: 'retiro/:id', component:RetiroComponent},
  //operacion consignacion
  {path: 'consignacion/:id', component:ConsignacionComponent},
  //operacion transferencia 
  {path: 'transferencia/:id/cuentaDestino/', component:TransferenciaComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
