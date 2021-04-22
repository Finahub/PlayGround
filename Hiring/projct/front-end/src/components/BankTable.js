import Button from './Button'
///import BankService from '../services/BankService';

const BankTable = ({ title, onAdd, bank }) => {
 
  return (
  
     
     
      <div>
                {/* <h1 className = "text-center"> Bank </h1> */}
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
                            bank.map(
                                bnk => 
                                <tr key = {bnk.id}>
                                     <td> {bnk.fields['Bank']}</td>   
                                     <td> {bnk.fields['Credit Card Count']}</td> 
                                     <td> {bnk.fields['Debit Card Count']}</td>    
                                     <td><Button
                                        color= 'green'
                                        text='Save bank'
                                       // onClick={saveBank(bnk)}
                                        /></td>
                                </tr>
                            )
                        }

                    </tbody>
                </table>
                
            </div>

     
   
  )
}


export default BankTable