import React, { Component } from "react";
import ApiService from "./ApiService";
import Table from "react-bootstrap/Table";

class Home extends Component {
  constructor(props) {
    super(props);
    this.state = {
      fields: null,
      isToggled: false,
    };
  }

  fetchRecords = () => {
    ApiService.listInfo().then((response) => {
      this.setState({ fields: response.data.fields });
    });
    this.toggle();
  };

  addRecords = () => {
    ApiService.postInfo(
      this.state.fields.Bank,
      this.state.fields["Credit Card Count"],
      this.state.fields["Debit Card Count"]
    );
  };

  toggle = () => {
    this.setState((prevState) => ({ toggle: !prevState.toggle }));
  };

  render() {
    return (
      <div>
        <button onClick={this.fetchRecords}>GET</button>
        {this.state.toggle ? (
          <div>
            <Table striped bordered hover>
              <thead>
                <tr>
                  <th>Bank</th>
                  <th>Credit Card Count</th>
                  <th>Debit Card Count</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>{this.state.fields && this.state.fields.Bank}</td>
                  <td>
                    {this.state.fields &&
                      this.state.fields["Credit Card Count"]}
                  </td>
                  <td>
                    {this.state.fields && this.state.fields["Debit Card Count"]}
                  </td>
                </tr>
              </tbody>
            </Table>
            <button onClick={this.addRecords}>POST</button>
          </div>
        ) : null}
      </div>
    );
  }
}

export default Home;
