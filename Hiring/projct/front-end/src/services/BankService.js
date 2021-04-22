import axios from 'axios'

const USERS_REST_API_URL = 'http://localhost:8090/api/banks';
const USERS_REST_API_URL1 = 'http://localhost:8090/api/banksave';



class BankService {

    getBank(){
        return axios.get(USERS_REST_API_URL);
    }

    saveBank(bnk){
        return axios.post(USERS_REST_API_URL1,bnk);
    }
}

export default new BankService();