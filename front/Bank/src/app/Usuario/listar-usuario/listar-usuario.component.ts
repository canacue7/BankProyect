import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Cuenta } from 'src/app/Models/Cuenta';
import { Usuario } from 'src/app/Models/Usuario';
import { UsuarioService } from 'src/app/Services/usuario.service';


@Component({
  selector: 'app-listar-usuario',
  templateUrl: './listar-usuario.component.html',
  styleUrls: ['./listar-usuario.component.css']
})
export class ListarUsuarioComponent implements OnInit {
  public usuarios?:Usuario[];
  public cuentas?:Cuenta[];

  constructor(private usuarioService: UsuarioService, private router:Router) { }

  ngOnInit(): void {
    this.usuarioService.getUsuarios().subscribe(data=>{this.usuarios=data})
  }

  Editar(userId:number){
    this.router.navigate(['/edit', userId]); 
  }

  Delete(usuario:Usuario){
    this.usuarioService.deleteUsuario(usuario.id).subscribe(data=>{this.usuarios.filter(p=>p!==usuario);
    alert("Usuario eliminado");}, error=>alert("User has active accounts"))
  }

  Cuentas(userId:number){
    
    //localStorage.setItem("id",usuario.id_usuario.toString());
    this.router.navigate(['/listarCuentas', userId]); 
    // this.cuentaService.getallCuentas().subscribe(data=>{this.usuarios.filter(p=>p!==usuario);
    // alert("Usuario eliminado");})
  }

}
