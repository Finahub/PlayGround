import React, { Component } from 'react';
class Table extends Component {
    render() { 
        return ( 
            <table>
                <thead>
                    <tr>
                        <th>Bank Name</th>
                        <th>Debit Card Count</th>
                        <th>Credit Card Count</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                    <td>{this.props.bankInfo.Bank}</td>
                    <td>{this.props.bankInfo['Debit Card Count']}</td>
                    <td>{this.props.bankInfo['Credit Card Count']}</td>
                    </tr>
                </tbody>
            </table>
         );
    }
}
 
export default Table;