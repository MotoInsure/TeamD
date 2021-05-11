import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { Login } from '../login.model';
import { UserService } from '../services/user.service';
import { User } from '../user.model';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  login : Login;
  pwd : boolean= true;
  userName : string;
  constructor(private service:UserService) { 
    this.login = new Login();
  }

  ngOnInit(): void {
  }

  loginUser(){    
    let user : User;
    this.service.validateLogin(this.login.userName,this.login.password).then(
      (result:User)=>{
        user = result;
        console.log(result);
        console.log(user);
        if(user!=null){
          localStorage.setItem("user",JSON.stringify(user));
                    
         } 
         else
           alert("Invalid credentials");
      });
  }
  toggle(){
    this.pwd = !this.pwd;
  }

  forgotPwd(){
    let password :User;
    //this.service.forgotPassword(this.userName).subscribe(data=>password=data);   
    //console.log(password);
    this.service.forgotPassword(this.userName).then(
      (result : User)=> {
        password=result;
        console.log(password.password);        
      }
    );
    
  }

}
