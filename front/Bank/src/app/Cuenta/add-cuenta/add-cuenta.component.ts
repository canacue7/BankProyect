import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { CuentaService } from 'src/app/Services/cuenta.service';

@Component({
  selector: 'app-add-cuenta',
  templateUrl: './add-cuenta.component.html',
  styleUrls: ['./add-cuenta.component.css']
})
export class AddCuentaComponent implements OnInit {
  profileForm = new FormGroup({
    estado: new FormControl(''),
    tipo_cuenta: new FormControl(''),
    saldo: new FormControl('')
  });
  constructor(private service: CuentaService, private route: ActivatedRoute, private router:Router) { }

  ngOnInit(): void {
  }

  Guardar(){
    const userId = this.route.snapshot.paramMap.get('id'); 

    const cuenta= this.profileForm.value
    this.service.addCuenta(cuenta,+userId).subscribe(data=>{alert("Se Agregó con exito");
    this.router.navigate(['/addCuenta', userId]);
  })
  }

}
