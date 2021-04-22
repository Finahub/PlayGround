import React, { Component } from 'react'
import BankComponent from './BankComponent';
import Header from './Header'



export default class Home extends Component {

  
    state = {
        bank: [],
        showAddBank:false
      }
    
      setShowAddBank = (v) => {
        this.setState({
            showAddBank:v
        })
      }


   fetchTasks = async () => {
    const res = await fetch('http://localhost:8090/api/banks')
    const data = await res.json()
    this.setState({
        bank:data
    })
    return data
  }

    render() {
        return (
              <div className='container'>
                <h1>{this.state.showAddBank}</h1>
                <Header
                onAdd={() => this.setShowAddBank(!this.state.showAddBank)}
                    showAdd={this.state.showAddBank}
                />
                {this.state.showAddBank &&<BankComponent />}

                </div>
        )
    }
}
