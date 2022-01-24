import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Cuenta } from 'src/app/Models/Cuenta';
import { Operaciones } from 'src/app/Models/Operaciones';
import { CuentaService } from 'src/app/Services/cuenta.service';

@Component({
  selector: 'app-listar-cuenta',
  templateUrl: './listar-cuenta.component.html',
  styleUrls: ['./listar-cuenta.component.css']
})
export class ListarCuentaComponent implements OnInit {
  public ops:Operaciones[];

  cuentas:Cuenta[];
  constructor(private cuentaService: CuentaService,private route: ActivatedRoute,  private router:Router) { }

  ngOnInit(): void {
    const userId = this.route.snapshot.paramMap.get('id'); 
    console.log(userId)
    this.cuentaService.getallCuentas(+userId).subscribe(data=>{this.cuentas=data})
  }

  Operaciones(accountId:number){
    
    //localStorage.setItem("id",usuario.id_usuario.toString());
    this.router.navigate(['/listarOperaciones', accountId]);
    // this.cuentaService.getallCuentas().subscribe(data=>{this.usuarios.filter(p=>p!==usuario);
    // alert("Usuario eliminado");})
  }

  Retirar(accountId:number){
    
   this.router.navigate(['/retirar', accountId]);

  }

  Ncuenta(){
    const userId = this.route.snapshot.paramMap.get('id'); 
    this.router.navigate(['/addCuenta', userId]);
  }
}
