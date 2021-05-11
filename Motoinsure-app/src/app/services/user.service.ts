import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { User } from '../user.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  baseUri : string = "http://localhost:8980/user/";
  constructor(private http:HttpClient) { }

  addUser(user :User){
    this.http.post(this.baseUri+"addUser",user).subscribe(data => data=user);
  }
  async validateLogin(username : string, password: string){
    console.log(2);    
    return await this.http.get<User>(this.baseUri+"auth?userName="+username+"&password="+password).toPromise();
  }

  // forgotPassword(userName:string): Observable<string>{
  //   return this.http.get<string>(this.baseUri+"forgotPwd/"+userName);
  // }
  async forgotPassword(userName:string){
    return this.http.get<User>(this.baseUri+"forgotPwd/"+userName).toPromise();
  }

  async addVehicle(registration:string, user :User){
    // let user =User;
    // user = JSON.parse(localStorage.getItem("user"));
    this.http.post(this.baseUri+"addVehicle/502/"+registration,user).toPromise();
    //this.http.post(this.baseUri+"addVehicle/"+user.id+"/"+registration,user).toPromise(););
  }

  async addPolicy(policyId:number,user:User){
    this.http.post(this.baseUri+"addPolicyToUser/502/"+policyId,user).toPromise();
    //this.http.post(this.baseUri+"addPolicyToUser/"+user.id+"/"+policyId,user).toPromise();
  }
}
