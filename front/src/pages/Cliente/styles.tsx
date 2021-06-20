import styled from 'styled-components';

export const Container = styled.div`
  width: 1200px;
  margin: 20px auto;
  font-family: 'Roboto', sans-serif;
  color: #666;

  h1 {
    font-size: 18px;
  }

  footer {
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 30px;

    div {
      display: flex;
      flex-direction: row;
      justify-content: space-between;
      align-items: center;
      font-size: 12px;
      font-weight: bold;

      a {
        background: #cccccc 0% 0% no-repeat padding-box;
        border: 0;
        border-radius: 4px;
        text-align: center;
        letter-spacing: 0px;
        color: #ffffff;
        opacity: 1;
        display: flex;
        align-items: center;
        justify-content: center;
        padding: 8px 20px;
        margin-right: 5px;
      }

      button {
        background: #7d40e7 0% 0% no-repeat padding-box;
        border: 0;
        border-radius: 4px;
        text-align: center;
        letter-spacing: 0px;
        color: #ffffff;
        opacity: 1;
        display: flex;
        align-items: center;
        justify-content: center;
        padding: 8px 20px;
        font-size: 12px;
        font-weight: bold;
      }
    }
  }
`;

export const Content = styled.div`
  width: 100%;
  text-align: center;
  padding: 50px 20px;
  border-radius: 4px;

  form {
    > div {
      background: #fff;
      padding: 30px;
      display: grid;
      grid-template-columns: repeat(auto-fill, minmax(400px, 1fr));
      grid-gap: 30px;
      margin-top: 20px;

      div {
        text-align: left;

        label {
          font-size: 14px;
          font-weight: 700;
          color: #999;
        }

        input {
          width: 100%;
          padding: 10px 15px;
          border: 1px solid #ccc;
          border-radius: 4px;
          color: #999;
          font-size: 16px;
        }
      }
    }
  }
`;
