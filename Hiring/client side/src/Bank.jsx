import React, { Component } from 'react';
import Table from './components/Table'
class Bank extends Component {
    constructor (){
        super();  
        this.state = {
            bankFields:{}
          };
        this.getBankInfo = this.getBankInfo.bind(this);
      }
    
    getBankInfo = ()=> {
    fetch("http://localhost:8080/get-bank-info")
    .then(response => {
       return  response.json();
    })
    .then(bank => {
        this.setState({bankFields : bank.fields});   
    });
    }
    saveBankInfo = ()=> {
        var data = {...this.state.bankFields};
        if(Object.keys(data).length === 0){
            alert("First Get Bank Info");
            return; 
        }
        const bankData ={};
        bankData['bankName'] = data.Bank;
        bankData['debitCardCount'] = data['Debit Card Count'];
        bankData['creditCardCount'] = data['Credit Card Count'];
        var obj={
            method: 'POST',
            mode: 'cors',
            headers: {
              'Content-Type': 'application/json'
            },
            referrerPolicy: 'no-referrer',
            body: JSON.stringify(bankData) 
          }
        fetch("http://localhost:8080/save-bank-info",obj)
        .then(response => {
            alert("Insertion Successful");  
        })
        
    }
    render() { 
        return (
        <React.Fragment>
            <button className="button" onClick={()=>this.getBankInfo()}
          >Get Bank Info
          </button>
          <Table bankInfo={this.state.bankFields}/>
          <button className="button1" onClick={()=>this.saveBankInfo()}
          >Save Bank Info
          </button>
        </React.Fragment>
        
          );
    }
}
 
export default Bank;