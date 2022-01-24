import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddUsuarioComponent } from './Usuario/add-usuario/add-usuario.component';
import { ListarUsuarioComponent } from './Usuario/listar-usuario/listar-usuario.component';
import { DeleterUsuarioComponent } from './Usuario/deleter-usuario/deleter-usuario.component';
import { EditUsuarioComponent } from './Usuario/edit-usuario/edit-usuario.component';
import { AddCuentaComponent } from './Cuenta/add-cuenta/add-cuenta.component';
import { ListarCuentaComponent } from './Cuenta/listar-cuenta/listar-cuenta.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { UsuarioService } from './Services/usuario.service';
import { HttpClientModule } from '@angular/common/http';
import { ListarOperacionesComponent } from './Operaciones/listar-operaciones/listar-operaciones.component';
import { ConsignacionComponent } from './Operaciones/consignacion/consignacion.component';
import { RetiroComponent } from './Operaciones/retiro/retiro.component';
import { TransferenciaComponent } from './Operaciones/transferencia/transferencia.component';

@NgModule({
  declarations: [
    AppComponent,
    AddUsuarioComponent,
    ListarUsuarioComponent,
    DeleterUsuarioComponent,
    EditUsuarioComponent,
    AddCuentaComponent,
    ListarCuentaComponent,
    ListarOperacionesComponent,
    ConsignacionComponent,
    RetiroComponent,
    TransferenciaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [UsuarioService],
  bootstrap: [AppComponent]
})
export class AppModule { }
