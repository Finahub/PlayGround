import React from 'react';
import BankService from '../services/BankService';
import Button from './Button';

import LastPage from './LastPage'

import {
    BrowserRouter as Router,
    Switch,
    Route,
    Link
  } from "react-router-dom";

class BankComponent extends React.Component {

    constructor(props){
        super(props)
        this.state = {
            bank:[],
            show:true
        }
    }
    
    componentDidMount(){
        BankService.getBank().then((response) => {
            this.setState({ bank: response.data})
            console.log(response.data);
        });
    }
    
    saveBank = (bnk) =>
    {
        let bankobj={bank: bnk.fields['Bank'],
        creditCardCount: bnk.fields['Credit Card Count'],
        debitCardCount: bnk.fields['Debit Card Count'],}
        BankService.saveBank(bankobj).then(res=>
            {
                this.setState({
                    show:false
                })
                
            });
    }
       

    render (){
        return (
            <div>
                {this.state.show?
                <table className = "table table-striped">
                    <thead>
                        <tr>

                           
                            <td> Bank Name</td>
                            <td> Credit Card Count</td>
                            <td> Debit Card Count</td>
                            <td> Action</td>
                        </tr>

                    </thead>
                    <tbody>
                        {
                            this.state.bank.map(
                                bnk => 
                                <tr key = {bnk.id}>
                                     <td> {bnk.fields['Bank']}</td>   
                                     <td> {bnk.fields['Credit Card Count']}</td> 
                                     <td> {bnk.fields['Debit Card Count']}</td>    
                                     <td><Button
                                        color= 'green'
                                        text='Save bank'
                                        onClick={this.saveBank.bind(this, bnk)}
                                        /></td>
                                </tr>
                            )
                        }

                    </tbody>
                </table>
                :
                <h4>Bank Details Added Successfully ... Thank you</h4>}
            </div>

        )
    }
}

export default BankComponent