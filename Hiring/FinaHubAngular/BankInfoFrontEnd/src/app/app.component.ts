import { Component } from '@angular/core';
import { Observable } from 'rxjs';
import { BankInfo } from './BankInfo.interface';
import { HttpClient } from '@angular/common/http';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'BankInfoFrontEnd';
  rows!: BankInfo[];
  errormsg: string="";
  savedBank!: string;
  
  onButtonClick(){
   
    console.log("hello");
    this.getAllBanksInfo()
    .subscribe(data=>{this.rows=data;
       },
      error=>this.errormsg=error);
      console.log(this.rows);
   
  }
  constructor(private http:HttpClient) {}
  getAllBanksInfo():Observable<BankInfo[]>
  {
    return this.http.get<BankInfo[]>("http://localhost:8080/banks");
  }

  saveThisBankInfo(bankInfo:BankInfo):void{
    console.log(bankInfo);
    this.http.post<BankInfo>("http://localhost:8080/saveBankInfo",bankInfo)
    .subscribe(data => {
      this.savedBank = data.BankName;
  });;
  setTimeout(() =>{ alert("Saved Successfully"); }, 3000);
  }
  
}
