# chat2
MIQS Exchange Solution WEB API

[Overview 4](#overview)

[Message Format 4](#message-format)

[Message Field Types 4](#message-field-types)

[Mandatory Field Indicators 4](#mandatory-field-indicators)

[REST API 4](#rest-api)

[General Information 4](#general-information)

[Success Response 4](#success-response)

[Error Response 4](#error-response)

[Pagination 5](#pagination)

[Rate Limits 5](#rate-limits)

[Public Endpoints 5](#public-endpoints)

[Instruments 5](#instruments)

[Ticker 6](#ticker)

[Order Book 6](#order-book)

[Trades 7](#trades)

[Charts 7](#charts)

[Private Endpoints 8](#private-endpoints)

[Orders 8](#orders)

[OwnTrades 9](#owntrades)

[New Order 10](#new-order)

[Cancel Order 10](#cancel-order)

[Cancel All Order 11](#cancel-all-order)

[Accounts 11](#accounts)

[Account Transactions 11](#account-transactions)

[Withdraw 12](#withdraw)

[WEBSOCKET API 13](#websocket-api)

[General Information 13](#general-information-1)

[Error Fields 13](#error-fields)

[Public Channels 13](#public-channels)

[Ticker 13](#ticker-1)

[Order Book 14](#order-book-1)

[Full Order Book channel 15](#full-order-book-channel)

[Trades 16](#trades-1)

[Charts 16](#charts-1)

[Private Channels 17](#private-channels)

[New Order 17](#new-order-1)

[Cancel Order 18](#cancel-order-1)

[Order Update 18](#order-update)

[Account Update 20](#account-update)

[Site UI only API 21](#site-ui-only-api)

[Public Endpoints 21](#public-endpoints-1)

[User Registration 21](#user-registration)

[User Login 22](#user-login)

[Get Security Question List 22](#get-security-question-list)

[Reset Password 22](#reset-password)

[Resend Email Confirmation 23](#resend-email-confirmation)

[Private Endpoints 23](#private-endpoints-1)

[Deposit 23](#deposit)

[Update Profile 23](#update-profile)

[Create New API Key 24](#create-new-api-key)

[Get API Keys 24](#get-api-keys)

[Delete API Key 24](#delete-api-key)

[Enable Google Authenticator 24](#enable-google-authenticator)

[Get KYC Requirements 25](#get-kyc-requirements)

[Submit KYC Request 25](#submit-kyc-request)

[Create New User Account 25](#create-new-user-account)

[Get User Accounts 25](#get-user-accounts)

[Delete User Account 26](#delete-user-account)

[Add Bank Account 26](#add-bank-account)

[Get Bank Accounts 26](#get-bank-accounts)

[Delete Bank Account 26](#delete-bank-account)

Overview
========

The Secure Web API allows client applications to view and update data
using the HTTPS protocol over the internet. The purpose of this document
is to provide the spec on the messages communicated through WEB API.

### Message Format

All messages are in json format.

### Message Field Types

<table>
<thead>
<tr class="header">
<th>Type</th>
<th></th>
<th></th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>Timestamp</td>
<td></td>
<td></td>
</tr>
<tr class="even">
<td>Integer</td>
<td>Without quote around the number</td>
<td></td>
</tr>
<tr class="odd">
<td>Boolean</td>
<td>True/False</td>
<td></td>
</tr>
<tr class="even">
<td>DoubleString</td>
<td>Double number quoted as a String</td>
<td></td>
</tr>
<tr class="odd">
<td>LongString</td>
<td>Long number quoted as a String</td>
<td></td>
</tr>
<tr class="even">
<td>String</td>
<td></td>
<td></td>
</tr>
</tbody>
</table>

### Mandatory Field Indicators

<table>
<thead>
<tr class="header">
<th>Indicator</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>M</td>
<td>This field is mandatory</td>
</tr>
<tr class="even">
<td>(M)</td>
<td>This field is mandatory under certain conditions</td>
</tr>
<tr class="odd">
<td>O</td>
<td>This field is optional</td>
</tr>
</tbody>
</table>

REST API
========

<https://www.xxxx.com/api>

General Information
-------------------

All requests and responses use application/json content type. Responses
follow HTTP response status codes to indicate the success and the
failure.

### Success Response

Successful http response contains HTTP status code 200 and an optional
body. If the response contains the body, the fields within the body are
documented in each related sections.

### Error Response

Failed http response contains non 200 HTTP status code and the body with
an errorCode field to indicate the cause of the failure. Error codes are
documented in each related sections.

#### Response Fields

<table>
<thead>
<tr class="header">
<th>Name</th>
<th>Type(value)</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>errorCode</td>
<td>String</td>
<td>Error code. e.g. INVALID_PASSWORD</td>
</tr>
</tbody>
</table>

### Pagination

Pagination is supported for all REST calls that return arrays. The
newest items are returned by default.

#### Parameters

<table>
<thead>
<tr class="header">
<th>Name</th>
<th>Type(value)</th>
<th>Mandatory</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>pageNumber</td>
<td>Integer</td>
<td>O</td>
<td>Default to 1</td>
</tr>
<tr class="even">
<td>pageSize</td>
<td>Integer</td>
<td>O</td>
<td>Default to 100</td>
</tr>
</tbody>
</table>

Example: GET api/orders?pageNumber=1&pageSize=100

### Rate Limits

Throttle public endpoints by IP: x requests per second

Throttle private endpoints by user ID: x requests per second

Public Endpoints
----------------

### Instruments

GET /api/public/instruments

#### Request Parameters

<table>
<thead>
<tr class="header">
<th>Name</th>
<th>Type(value)</th>
<th>Mandatory</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>instrumentId</td>
<td>String</td>
<td>O</td>
<td></td>
</tr>
<tr class="even">
<td>productType</td>
<td>String</td>
<td>O</td>
<td>Spot/Futures/Indexes</td>
</tr>
<tr class="odd">
<td>symbol</td>
<td>String</td>
<td>O</td>
<td></td>
</tr>
<tr class="even">
<td>quoteCurrency</td>
<td>String</td>
<td>O</td>
<td></td>
</tr>
<tr class="odd">
<td>underlying</td>
<td>String</td>
<td>O</td>
<td></td>
</tr>
</tbody>
</table>

#### Success Response Body Fields

<table>
<thead>
<tr class="header">
<th>Name</th>
<th>Type(value)</th>
<th>Mandatory</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>instrumentId</td>
<td>String</td>
<td>M</td>
<td>e.g. BTCUSD</td>
</tr>
<tr class="even">
<td>symbol</td>
<td>String</td>
<td>M</td>
<td>e.g. BTC</td>
</tr>
<tr class="odd">
<td>quoteCurrency</td>
<td>String</td>
<td>M</td>
<td>e.g. USD</td>
</tr>
<tr class="even">
<td>productType</td>
<td>String</td>
<td>M</td>
<td>Spot/Futures/Indexes</td>
</tr>
<tr class="odd">
<td>tickSize</td>
<td>DoubleString</td>
<td>M</td>
<td>e.g. 0.01</td>
</tr>
<tr class="even">
<td>lotSize</td>
<td>Integer</td>
<td>(M)</td>
<td>Mandatory for tradable Spot and Futures instruments e.g. 1</td>
</tr>
<tr class="odd">
<td>minOrderSize</td>
<td>DoubleString</td>
<td>(M)</td>
<td>Mandatory for tradable Spot and Futures instruments</td>
</tr>
<tr class="even">
<td>maxOrderSize</td>
<td>DoubleString</td>
<td>(M)</td>
<td>Mandatory for tradable Spot and Futures instruments</td>
</tr>
<tr class="odd">
<td>expiry</td>
<td>Timestamp</td>
<td>(M)</td>
<td>Mandatory for futures instrument</td>
</tr>
<tr class="even">
<td>underlying</td>
<td>String</td>
<td>(M)</td>
<td>Mandatory for futures instrument</td>
</tr>
<tr class="odd">
<td>contractMultipler</td>
<td>Integer</td>
<td>(M)</td>
<td>Mandatory for futures instrument</td>
</tr>
</tbody>
</table>

#### Failure Error Codes

<table>
<thead>
<tr class="header">
<th>Error Code</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td></td>
<td></td>
</tr>
</tbody>
</table>

### Ticker

GET /api/public/ticker

#### Request Parameters

<table>
<thead>
<tr class="header">
<th>Name</th>
<th>Type(value)</th>
<th>Mandatory</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>instrumentId</td>
<td>String</td>
<td>M</td>
<td>e.g. “BTCUSD”</td>
</tr>
</tbody>
</table>

#### Success Response Body Fields

<table>
<thead>
<tr class="header">
<th>Name</th>
<th>Type(value)</th>
<th>Mandatory</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>instrumentId</td>
<td>String</td>
<td>M</td>
<td>e.g. “BTCUSD”</td>
</tr>
<tr class="even">
<td>time</td>
<td>Timestamp</td>
<td>M</td>
<td></td>
</tr>
<tr class="odd">
<td>lastPrice</td>
<td>DoubleString</td>
<td>M</td>
<td></td>
</tr>
<tr class="even">
<td>bestBid</td>
<td>DoubleString</td>
<td>M</td>
<td></td>
</tr>
<tr class="odd">
<td>bestAsk</td>
<td>DoubleString</td>
<td>M</td>
<td></td>
</tr>
<tr class="even">
<td>24hHigh</td>
<td>DoubleString</td>
<td>M</td>
<td></td>
</tr>
<tr class="odd">
<td>24hLow</td>
<td>DoubleString</td>
<td>M</td>
<td></td>
</tr>
<tr class="even">
<td>24hVolume</td>
<td>LongString</td>
<td>M</td>
<td></td>
</tr>
<tr class="odd">
<td>24hChange</td>
<td>DoubleString</td>
<td>M</td>
<td></td>
</tr>
</tbody>
</table>

#### Failure Error Codes

<table>
<thead>
<tr class="header">
<th>Error Code</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td></td>
<td></td>
</tr>
</tbody>
</table>

### Order Book

GET /api/public/orderbook

#### Request Parameters

<table>
<thead>
<tr class="header">
<th>Name</th>
<th>Type(value)</th>
<th>Mandatory</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>instrumentId</td>
<td>String</td>
<td>M</td>
<td>e.g. “BTCUSD”</td>
</tr>
<tr class="even">
<td>level</td>
<td>Integer</td>
<td>M</td>
<td><p>1 - top bid and ask</p>
<p>2 – order book</p>
<p>3 – full order level book</p></td>
</tr>
</tbody>
</table>

#### Success Response Body Fields

<table>
<thead>
<tr class="header">
<th>Name</th>
<th>Type(value)</th>
<th>Mandatory</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>instrumentId</td>
<td>String</td>
<td>M</td>
<td></td>
</tr>
<tr class="even">
<td>level</td>
<td>1/2/3</td>
<td>M</td>
<td></td>
</tr>
<tr class="odd">
<td>sequence</td>
<td>LongString</td>
<td>M</td>
<td></td>
</tr>
<tr class="even">
<td>bids</td>
<td>Array of [price, size, numOfOrders/orderId]</td>
<td>M</td>
<td><p>Level 1 – This is one sized array</p>
<p>Level 2 – The aggregated size for each price level is returned with numOfOrders count for the price</p>
<p>Level 3 – The order level information is returned</p></td>
</tr>
<tr class="odd">
<td>asks</td>
<td>Array of [price, size, numOfOrders/orderId]</td>
<td>M</td>
<td><p>Level 1 – This is one sized array</p>
<p>Level 2 – The aggregated size for each price level is returned with numOfOrders count for the price</p>
<p>Level 3 – The order level information is returned</p></td>
</tr>
</tbody>
</table>

#### Failure Error Codes

<table>
<thead>
<tr class="header">
<th>Error Code</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td></td>
<td></td>
</tr>
</tbody>
</table>

### Trades

GET /api/public/trades

#### Request Parameters

<table>
<thead>
<tr class="header">
<th>Name</th>
<th>Type(value)</th>
<th>Mandatory</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>instrumentId</td>
<td>String</td>
<td>M</td>
<td></td>
</tr>
</tbody>
</table>

#### Success Response Body Fields

<table>
<thead>
<tr class="header">
<th>Name</th>
<th>Type(value)</th>
<th>Mandatory</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>time</td>
<td>Timestamp</td>
<td>M</td>
<td></td>
</tr>
<tr class="even">
<td>tradeId</td>
<td>String</td>
<td>M</td>
<td></td>
</tr>
<tr class="odd">
<td>price</td>
<td>DoubleString</td>
<td>M</td>
<td></td>
</tr>
<tr class="even">
<td>size</td>
<td>DoubleString</td>
<td>M</td>
<td></td>
</tr>
<tr class="odd">
<td>side</td>
<td>String</td>
<td>M</td>
<td>Buy/Sell</td>
</tr>
</tbody>
</table>

#### Failure Error Codes

<table>
<thead>
<tr class="header">
<th>Error Code</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td></td>
<td></td>
</tr>
</tbody>
</table>

### Charts

GET /api/public/charts

It returns an array of data point stats.

#### Request Parameters

<table>
<thead>
<tr class="header">
<th>Name</th>
<th>Type(value)</th>
<th>Mandatory</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>instrumentId</td>
<td>String</td>
<td>M</td>
<td></td>
</tr>
<tr class="even">
<td>startTime</td>
<td>Timestamp</td>
<td>M</td>
<td></td>
</tr>
<tr class="odd">
<td>endTime</td>
<td>Timestamp</td>
<td>M</td>
<td></td>
</tr>
<tr class="even">
<td>granularity</td>
<td>Integer</td>
<td>M</td>
<td><p>In seconds; 60/300/900/3600/21600/86400;</p>
<p>The combination of startTime, endTime and granularity determines how many data points obtained. The maximum supported number of data points is xxx</p></td>
</tr>
</tbody>
</table>

#### Success Response Body Fields

<table>
<thead>
<tr class="header">
<th>Name</th>
<th>Type(value)</th>
<th>Mandatory</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>startTime</td>
<td>Timestamp</td>
<td>M</td>
<td></td>
</tr>
<tr class="even">
<td>endTime</td>
<td>Timestamp</td>
<td>M</td>
<td></td>
</tr>
<tr class="odd">
<td>openPrice</td>
<td>String</td>
<td>M</td>
<td></td>
</tr>
<tr class="even">
<td>closePrice</td>
<td>String</td>
<td>M</td>
<td></td>
</tr>
<tr class="odd">
<td>low</td>
<td>String</td>
<td>M</td>
<td></td>
</tr>
<tr class="even">
<td>high</td>
<td>String</td>
<td>M</td>
<td></td>
</tr>
<tr class="odd">
<td>volume</td>
<td>String</td>
<td>M</td>
<td></td>
</tr>
</tbody>
</table>

#### Failure Error Codes

<table>
<thead>
<tr class="header">
<th>Error Code</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td></td>
<td></td>
</tr>
</tbody>
</table>

Private Endpoints
-----------------

All requests to private endpoints require authentication. For each REST
call, API\_KEY, SIGNATURE and NONCE should be encoded in HTTP headers.

### Orders

GET /api/private/orders

Returns an array of orders; Pagination is supported. Cancelled orders in
the most recent 2 days are included, the older cancelled orders are not.

#### Request Parameters

<table>
<thead>
<tr class="header">
<th>Name</th>
<th>Type(value)</th>
<th>Mandatory</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>orderId</td>
<td>String</td>
<td>O</td>
<td></td>
</tr>
<tr class="even">
<td>instrumentId</td>
<td>String</td>
<td>O</td>
<td>If not provided, orders for all symbols are returned</td>
</tr>
<tr class="odd">
<td>status</td>
<td><p>Open, Executed,</p>
<p>Partial Executed, Cancelled</p></td>
<td>O</td>
<td>If not provided, orders for all status are returned</td>
</tr>
</tbody>
</table>

#### Success Response Body Fields

<table>
<thead>
<tr class="header">
<th>Name</th>
<th>Type(value)</th>
<th>Mandatory</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>orderId</td>
<td>String</td>
<td>M</td>
<td></td>
</tr>
<tr class="even">
<td>instrumentId</td>
<td>String</td>
<td>M</td>
<td></td>
</tr>
<tr class="odd">
<td>userAccount</td>
<td>String</td>
<td>M</td>
<td>User may have multiple accounts in firm user case.</td>
</tr>
<tr class="even">
<td>type</td>
<td>Market, Limit, Stop, StopLimit</td>
<td>M</td>
<td></td>
</tr>
<tr class="odd">
<td>price</td>
<td>DoubleString</td>
<td>M</td>
<td></td>
</tr>
<tr class="even">
<td>size</td>
<td>DoubleString</td>
<td>M</td>
<td></td>
</tr>
<tr class="odd">
<td>side</td>
<td>Buy/Sell</td>
<td>M</td>
<td></td>
</tr>
<tr class="even">
<td>timeInForce</td>
<td>GTC, GTT, IOC, FOK</td>
<td>M</td>
<td></td>
</tr>
<tr class="odd">
<td>orderTime</td>
<td>Timestamp</td>
<td>M</td>
<td></td>
</tr>
<tr class="even">
<td>stopPrice</td>
<td>DoubleString</td>
<td>O</td>
<td></td>
</tr>
<tr class="odd">
<td>status</td>
<td>Open, Executed, Cancelled</td>
<td>M</td>
<td></td>
</tr>
<tr class="even">
<td>executedSize</td>
<td>DoubleString</td>
<td>O</td>
<td></td>
</tr>
<tr class="odd">
<td>executedPrice</td>
<td>DoubleString</td>
<td>O</td>
<td></td>
</tr>
<tr class="even">
<td>postLiquidity</td>
<td>Boolean</td>
<td>M</td>
<td>True – order rest in the book initially</td>
</tr>
<tr class="odd">
<td>fee</td>
<td>DoubleString</td>
<td>O</td>
<td></td>
</tr>
<tr class="even">
<td>selfTradePrevention</td>
<td>String</td>
<td>M</td>
<td><p>DC – Decrease and cancel</p>
<p>CO – Cancel oldest</p>
<p>CN – Cancel newest</p>
<p>CB – Cancel both</p></td>
</tr>
<tr class="odd">
<td>clientOrderId</td>
<td>String</td>
<td>O</td>
<td></td>
</tr>
</tbody>
</table>

#### Failure Error Codes

<table>
<thead>
<tr class="header">
<th>Error Code</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td></td>
<td></td>
</tr>
</tbody>
</table>

### OwnTrades

GET /api/private/ownTrades

#### Request Parameters

<table>
<thead>
<tr class="header">
<th>Name</th>
<th>Type(value)</th>
<th>Mandatory</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>orderId</td>
<td>String</td>
<td>O</td>
<td></td>
</tr>
<tr class="even">
<td>instrumentId</td>
<td>String</td>
<td>O</td>
<td>If not provided, orders for all symbols are returned</td>
</tr>
</tbody>
</table>

#### Success Response Body Fields

<table>
<thead>
<tr class="header">
<th>Name</th>
<th>Type(value)</th>
<th>Mandatory</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>time</td>
<td>Timestamp</td>
<td>M</td>
<td></td>
</tr>
<tr class="even">
<td>tradeId</td>
<td>String</td>
<td>M</td>
<td></td>
</tr>
<tr class="odd">
<td>userAccount</td>
<td>String</td>
<td>M</td>
<td></td>
</tr>
<tr class="even">
<td>price</td>
<td>DoubleString</td>
<td>M</td>
<td></td>
</tr>
<tr class="odd">
<td>size</td>
<td>DoubleString</td>
<td>M</td>
<td></td>
</tr>
<tr class="even">
<td>side</td>
<td>String</td>
<td>M</td>
<td>Buy/Sell</td>
</tr>
<tr class="odd">
<td>fee</td>
<td>DoubleString</td>
<td>M</td>
<td></td>
</tr>
<tr class="even">
<td>liquidity</td>
<td>String</td>
<td>M</td>
<td><p>M – liquidity maker</p>
<p>T – liquidity taker</p></td>
</tr>
</tbody>
</table>

#### Failure Error Codes

<table>
<thead>
<tr class="header">
<th>Error Code</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td></td>
<td></td>
</tr>
</tbody>
</table>

### New Order

POST /api/private/newOrder

#### Request Parameters:

<table>
<thead>
<tr class="header">
<th>Name</th>
<th>Type(value)</th>
<th>Mandatory</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>instrumentId</td>
<td>String</td>
<td>M</td>
<td></td>
</tr>
<tr class="even">
<td>userAccount</td>
<td>String</td>
<td>M</td>
<td>User account used for this order</td>
</tr>
<tr class="odd">
<td>orderType</td>
<td>String</td>
<td>M</td>
<td>Limit/Market/Stop/StopLimit</td>
</tr>
<tr class="even">
<td>price</td>
<td>DoubleString</td>
<td>(M)</td>
<td>Mandatory if order is non Market order</td>
</tr>
<tr class="odd">
<td>size</td>
<td>DoubleString</td>
<td>(M)</td>
<td><p>Mandatory if order is non Market order</p>
<p>For Market order, the user can either provide size or amount in quote currency</p></td>
</tr>
<tr class="even">
<td>amount</td>
<td>DoubleString</td>
<td>O</td>
<td>Amount in quote currency to buy/sell</td>
</tr>
<tr class="odd">
<td>side</td>
<td>Buy/Sell</td>
<td>M</td>
<td></td>
</tr>
<tr class="even">
<td>timeInForce</td>
<td>GTC, GTT, IOC FOK</td>
<td>M</td>
<td></td>
</tr>
<tr class="odd">
<td>clientOrderId</td>
<td>String</td>
<td>O</td>
<td></td>
</tr>
<tr class="even">
<td>stopPrice</td>
<td>NumberString</td>
<td>(M)</td>
<td>Mandatory if orderType is Stop or StopLimit</td>
</tr>
<tr class="odd">
<td>postOnly</td>
<td>Boolean</td>
<td>O</td>
<td>Default to false. If any part of the order results in taking liquidity, the order will be rejected and no part of it will execute.</td>
</tr>
<tr class="even">
<td>selfTradePrevention</td>
<td>String</td>
<td>O</td>
<td><p>Decrease and cancel (Default)</p>
<p>Cancel oldest;</p>
<p>Cancel newest;</p>
<p>Cancel both;</p></td>
</tr>
</tbody>
</table>

#### Success Response Body Fields

<table>
<thead>
<tr class="header">
<th>Name</th>
<th>Type(Value)</th>
<th>Mandatory</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>clientOrderId</td>
<td>String</td>
<td>(M)</td>
<td>Mandatory if clientOrderId is provided by the user</td>
</tr>
<tr class="even">
<td>orderId</td>
<td>String</td>
<td>M</td>
<td>System generated unique order id</td>
</tr>
</tbody>
</table>

#### Failure Error Codes

<table>
<thead>
<tr class="header">
<th>Error Code</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td></td>
<td></td>
</tr>
</tbody>
</table>

### Cancel Order

POST /api/private/cancelOrder

#### Request Parameters

<table>
<thead>
<tr class="header">
<th>Name</th>
<th>Type(value)</th>
<th>Mandatory</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>orderId</td>
<td>String</td>
<td>M</td>
<td></td>
</tr>
<tr class="even">
<td>clientOrderId</td>
<td>String</td>
<td>(M)</td>
<td></td>
</tr>
</tbody>
</table>

#### Success Response Body Fields

<table>
<thead>
<tr class="header">
<th>Name</th>
<th>Type(value)</th>
<th>Mandatory</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>orderId</td>
<td>String</td>
<td>(M)</td>
<td>Mandatory if client order id is not provided</td>
</tr>
<tr class="even">
<td>clientOrderId</td>
<td>String</td>
<td>(M)</td>
<td>Mandatory if order id is not provided</td>
</tr>
</tbody>
</table>

#### Failure Error Codes

<table>
<thead>
<tr class="header">
<th>Error Code</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td></td>
<td></td>
</tr>
</tbody>
</table>

### Cancel All Order

POST /api/private/cancelAllOrders

#### Success Response Body Fields

<table>
<thead>
<tr class="header">
<th>Name</th>
<th>Type(value)</th>
<th>Mandatory</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>orderIds</td>
<td>Array of Strings</td>
<td>M</td>
<td>Orders that are cancelled in the system</td>
</tr>
</tbody>
</table>

#### Failure Error Codes

<table>
<thead>
<tr class="header">
<th>Error Code</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td></td>
<td></td>
</tr>
</tbody>
</table>

### Accounts

GET /api/private/accounts

#### Request Parameters

<table>
<thead>
<tr class="header">
<th>Name</th>
<th>Type(value)</th>
<th>Mandatory</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>userAccount</td>
<td>String</td>
<td>O</td>
<td>Main account by default</td>
</tr>
</tbody>
</table>

#### Success Response Body Fields

<table>
<thead>
<tr class="header">
<th>Name</th>
<th>Type(value)</th>
<th>Mandatory</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>accountId</td>
<td>String</td>
<td>M</td>
<td></td>
</tr>
<tr class="even">
<td>currency</td>
<td>String</td>
<td>M</td>
<td></td>
</tr>
<tr class="odd">
<td>balance</td>
<td>DoubleString</td>
<td>M</td>
<td></td>
</tr>
<tr class="even">
<td>available</td>
<td>DoubleString</td>
<td>M</td>
<td></td>
</tr>
</tbody>
</table>

#### Failure Error Codes

<table>
<thead>
<tr class="header">
<th>Error Code</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td></td>
<td></td>
</tr>
</tbody>
</table>

### Account Transactions

GET /api/private/accountTransactions

List all the account transactions that either increases or decreases the
account balance and available balance. Pagination is supported.

#### Request Parameters

<table>
<thead>
<tr class="header">
<th>Name</th>
<th>Type(value)</th>
<th>Mandatory</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>accountId</td>
<td>String</td>
<td>O</td>
<td></td>
</tr>
<tr class="even">
<td>transactionType</td>
<td>String</td>
<td>O</td>
<td></td>
</tr>
<tr class="odd">
<td>referenceId</td>
<td>String</td>
<td>O</td>
<td></td>
</tr>
</tbody>
</table>

#### Success Response Body Fields

<table>
<thead>
<tr class="header">
<th>Name</th>
<th>Type(value)</th>
<th>Mandatory</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>transactionId</td>
<td>String</td>
<td>M</td>
<td></td>
</tr>
<tr class="even">
<td>userAccount</td>
<td>String</td>
<td>M</td>
<td></td>
</tr>
<tr class="odd">
<td>accountId</td>
<td>String</td>
<td>M</td>
<td></td>
</tr>
<tr class="even">
<td>currency</td>
<td>String</td>
<td>M</td>
<td></td>
</tr>
<tr class="odd">
<td>transactionType</td>
<td>String</td>
<td>M</td>
<td>Trade/Deposit/Withdraw/Fee/Rebate/Order/PendingWithdraw</td>
</tr>
<tr class="even">
<td>amount</td>
<td>DoubleString</td>
<td>M</td>
<td></td>
</tr>
<tr class="odd">
<td>balance</td>
<td>DoubleString</td>
<td>M</td>
<td></td>
</tr>
<tr class="even">
<td>available</td>
<td>DoubleString</td>
<td>M</td>
<td></td>
</tr>
<tr class="odd">
<td>timestamp</td>
<td>Timestamp</td>
<td>M</td>
<td></td>
</tr>
<tr class="even">
<td>referenceId</td>
<td>String</td>
<td>M</td>
<td><p>Additional information</p>
<p>Trade – {tradeId}</p>
<p>Withdraw – {withdrawId}</p>
<p>Fee – {tradeId or withdrawId}</p>
<p>Order – {orderId}</p>
<p>WithdrawRequest – {withdrawId}</p></td>
</tr>
</tbody>
</table>

#### Failure Error Codes

<table>
<thead>
<tr class="header">
<th>Error Code</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td></td>
<td></td>
</tr>
</tbody>
</table>

### Withdraw

POST /api/private/withdraw

#### Request Parameters

<table>
<thead>
<tr class="header">
<th>Name</th>
<th>Type(value)</th>
<th>Mandatory</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>accountId</td>
<td>String</td>
<td>M</td>
<td></td>
</tr>
<tr class="even">
<td>amount</td>
<td>String</td>
<td>M</td>
<td></td>
</tr>
<tr class="odd">
<td>address</td>
<td>String</td>
<td>M</td>
<td>bankId or cryto address</td>
</tr>
</tbody>
</table>

#### Success Response Body Fields

<table>
<thead>
<tr class="header">
<th>Name</th>
<th>Type(value)</th>
<th>Mandatory</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>withdrawId</td>
<td>String</td>
<td>M</td>
<td></td>
</tr>
</tbody>
</table>

#### Failure Error Codes

<table>
<thead>
<tr class="header">
<th>Error Code</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td></td>
<td></td>
</tr>
</tbody>
</table>

WEBSOCKET API
=============

wss://ws-api.xxxx.com

General Information
-------------------

All messages sent and received through websocket are encoded in JSON
format. All messages have a **type** attribute that can be used to
handle the message.

### Error Fields

Failures will cause an error message to be emitted with error code.
Error codes are documented in related sections.

<table>
<thead>
<tr class="header">
<th>Name</th>
<th>Type(value)</th>
<th>Mandatory</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>type</td>
<td>error</td>
<td>M</td>
<td>Error message type</td>
</tr>
<tr class="even">
<td>userMessageId</td>
<td>Integer</td>
<td>(M)</td>
<td>Mandatory if userMessageId is provided in the user request</td>
</tr>
<tr class="odd">
<td>errorCode</td>
<td>String</td>
<td>M</td>
<td>Error code</td>
</tr>
</tbody>
</table>

Public Channels
---------------

### Ticker

#### Request Fields

<table>
<thead>
<tr class="header">
<th>Name</th>
<th>Type(value)</th>
<th>Mandatory</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>type</td>
<td>subscribe</td>
<td>M</td>
<td>Subscribe/Unsubscribe message type</td>
</tr>
<tr class="even">
<td>channel</td>
<td>ticker</td>
<td>M</td>
<td></td>
</tr>
<tr class="odd">
<td>userMessageId</td>
<td>Integer</td>
<td>O</td>
<td>Unique message id for this websocket session</td>
</tr>
<tr class="even">
<td>instrumentIds</td>
<td>Array of instrumentId Strings</td>
<td>M</td>
<td></td>
</tr>
</tbody>
</table>

#### Response Fields

<table>
<thead>
<tr class="header">
<th>Name</th>
<th>Type(value)</th>
<th>Mandatory</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>type</td>
<td>subscribed</td>
<td>M</td>
<td>Subscribe/Unsubscribe message type</td>
</tr>
<tr class="even">
<td>channel</td>
<td>ticker</td>
<td>M</td>
<td></td>
</tr>
<tr class="odd">
<td>instrumentIds</td>
<td>Array of instrumentId Strings</td>
<td>M</td>
<td></td>
</tr>
<tr class="even">
<td>userMessageId</td>
<td>Integer</td>
<td>(M)</td>
<td>Mandatory if userMessageId is provided in the user request</td>
</tr>
</tbody>
</table>

#### Channel Fields:

<table>
<thead>
<tr class="header">
<th>Name</th>
<th>Type(value)</th>
<th>Mandatory</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>type</td>
<td>ticker</td>
<td>M</td>
<td></td>
</tr>
<tr class="even">
<td>instrumentId</td>
<td>String</td>
<td>M</td>
<td>e.g. “BTCUSD”</td>
</tr>
<tr class="odd">
<td>time</td>
<td>Timestamp</td>
<td>M</td>
<td></td>
</tr>
<tr class="even">
<td>lastPrice</td>
<td>DoubleString</td>
<td>M</td>
<td></td>
</tr>
<tr class="odd">
<td>bestBid</td>
<td>DoubleString</td>
<td>M</td>
<td></td>
</tr>
<tr class="even">
<td>bestAsk</td>
<td>DoubleString</td>
<td>M</td>
<td></td>
</tr>
<tr class="odd">
<td>24hHigh</td>
<td>DoubleString</td>
<td>M</td>
<td></td>
</tr>
<tr class="even">
<td>24hLow</td>
<td>DoubleString</td>
<td>M</td>
<td></td>
</tr>
<tr class="odd">
<td>24hVolume</td>
<td>LongString</td>
<td>M</td>
<td></td>
</tr>
<tr class="even">
<td>24hChange</td>
<td>DoubleString</td>
<td>M</td>
<td></td>
</tr>
</tbody>
</table>

#### Failure Error Codes

<table>
<thead>
<tr class="header">
<th>Error Code</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td></td>
<td></td>
</tr>
</tbody>
</table>

### Order Book

#### Request Fields

<table>
<thead>
<tr class="header">
<th>Name</th>
<th>Type(value)</th>
<th>Mandatory</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>type</td>
<td>subscribe</td>
<td>M</td>
<td>Subscribe/Unsubscribe message type</td>
</tr>
<tr class="even">
<td>channel</td>
<td>orderBook</td>
<td>M</td>
<td></td>
</tr>
<tr class="odd">
<td>depth</td>
<td>Integer</td>
<td>O</td>
<td>Default to 25</td>
</tr>
<tr class="even">
<td>instrumentIds</td>
<td>Array of instrumentId Strings</td>
<td>M</td>
<td></td>
</tr>
<tr class="odd">
<td>userMessageId</td>
<td>Integer</td>
<td>O</td>
<td>Unique message id for this websocket session</td>
</tr>
</tbody>
</table>

#### Response Fields

<table>
<thead>
<tr class="header">
<th>Name</th>
<th>Type(value)</th>
<th>Mandatory</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>type</td>
<td>subscribed</td>
<td>M</td>
<td>Subscribe/Unsubscribe message type</td>
</tr>
<tr class="even">
<td>channel</td>
<td>orderBook</td>
<td>M</td>
<td></td>
</tr>
<tr class="odd">
<td>depth</td>
<td>Integer</td>
<td>M</td>
<td></td>
</tr>
<tr class="even">
<td>instrumentIds</td>
<td>Array of instrumentId Strings</td>
<td>M</td>
<td></td>
</tr>
<tr class="odd">
<td>userMessageId</td>
<td>Integer</td>
<td>(M)</td>
<td>Mandatory if userMessageId is provided in the user request</td>
</tr>
</tbody>
</table>

#### Channel Fields

<table>
<thead>
<tr class="header">
<th>Name</th>
<th>Type(value)</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>type</td>
<td>orderBook</td>
<td></td>
</tr>
<tr class="even">
<td>instrumentId</td>
<td>String</td>
<td></td>
</tr>
<tr class="odd">
<td>time</td>
<td>Timestamp</td>
<td></td>
</tr>
<tr class="even">
<td>bids</td>
<td>Array of [price, size, numOfOrders]</td>
<td>The aggregated size for each price level is returned with numOfOrders count for the price</td>
</tr>
<tr class="odd">
<td>asks</td>
<td>Array of [price, size, numOfOrders]</td>
<td>The aggregated size for each price level is returned with numOfOrders count for the price</td>
</tr>
</tbody>
</table>

The initial bids and asks contain the full depth that the user
subscribes for. The subsequent messages only contain the updates.

#### Failure Error Codes

<table>
<thead>
<tr class="header">
<th>Error Code</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td></td>
<td></td>
</tr>
</tbody>
</table>

### Full Order Book channel

#### Request Fields

<table>
<thead>
<tr class="header">
<th>Name</th>
<th>Type(value)</th>
<th>Mandatory</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>type</td>
<td>subscribe</td>
<td>M</td>
<td>Subscribe/Unsubscribe message type</td>
</tr>
<tr class="even">
<td>channel</td>
<td>fullOrderBook</td>
<td>M</td>
<td></td>
</tr>
<tr class="odd">
<td>instrumentIds</td>
<td>Array of instrumentId Strings</td>
<td>M</td>
<td></td>
</tr>
<tr class="even">
<td>userMessageId</td>
<td>Integer</td>
<td>O</td>
<td>Unique message id for this websocket session</td>
</tr>
</tbody>
</table>

#### Response Fields

<table>
<thead>
<tr class="header">
<th>Name</th>
<th>Type(value)</th>
<th>Mandatory</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>type</td>
<td>subscribed</td>
<td>M</td>
<td>Subscribe/Unsubscribe message type</td>
</tr>
<tr class="even">
<td>channel</td>
<td>fullOrderBook</td>
<td>M</td>
<td></td>
</tr>
<tr class="odd">
<td>instrumentIds</td>
<td>Array of instrumentId Strings</td>
<td>M</td>
<td></td>
</tr>
<tr class="even">
<td>userMessageId</td>
<td>Integer</td>
<td>(M)</td>
<td>Mandatory if userMessageId is provided in the user request</td>
</tr>
</tbody>
</table>

#### Channel Fields

<table>
<thead>
<tr class="header">
<th>Name</th>
<th>Type(value)</th>
<th>Mandatory</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>type</td>
<td>fullOrderBook</td>
<td>M</td>
<td></td>
</tr>
<tr class="even">
<td>instrumentId</td>
<td>String</td>
<td>M</td>
<td></td>
</tr>
<tr class="odd">
<td>orderId</td>
<td>String</td>
<td>M</td>
<td></td>
</tr>
<tr class="even">
<td>price</td>
<td>DoubleString</td>
<td>M</td>
<td></td>
</tr>
<tr class="odd">
<td>remainingSize</td>
<td>DoubleString</td>
<td>M</td>
<td></td>
</tr>
<tr class="even">
<td>status</td>
<td>String</td>
<td>M</td>
<td></td>
</tr>
<tr class="odd">
<td>side</td>
<td>String</td>
<td>M</td>
<td></td>
</tr>
<tr class="even">
<td>sequence</td>
<td>LongString</td>
<td>M</td>
<td></td>
</tr>
</tbody>
</table>

Sequence to process full order book:

1.  Subscribe for fullOrderBook channel

2.  Call REST to get order book snapshot

3.  Playback queued messages and ignore the ones with the smaller
    sequence in the messages.

4.  Apply the update to orderbook

#### Failure Error Codes

<table>
<thead>
<tr class="header">
<th>Error Code</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td></td>
<td></td>
</tr>
</tbody>
</table>

### Trades

#### Request Fields

<table>
<thead>
<tr class="header">
<th>Name</th>
<th>Type(value)</th>
<th>Mandatory</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>type</td>
<td>subscribe</td>
<td>M</td>
<td>Subscribe/Unsubscribe message type</td>
</tr>
<tr class="even">
<td>channel</td>
<td>trades</td>
<td>M</td>
<td></td>
</tr>
<tr class="odd">
<td>instrumentIds</td>
<td>Array of instrumentId Strings</td>
<td>M</td>
<td></td>
</tr>
<tr class="even">
<td>userMessageId</td>
<td>Integer</td>
<td>O</td>
<td>Unique message id for this websocket session</td>
</tr>
</tbody>
</table>

#### Response Fields

<table>
<thead>
<tr class="header">
<th>Name</th>
<th>Type(value)</th>
<th>Mandatory</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>type</td>
<td>subscribed</td>
<td>M</td>
<td>Subscribe/Unsubscribe message type</td>
</tr>
<tr class="even">
<td>channel</td>
<td>trade</td>
<td>M</td>
<td></td>
</tr>
<tr class="odd">
<td>instrumentIds</td>
<td>Array of instrumentId Strings</td>
<td>M</td>
<td></td>
</tr>
<tr class="even">
<td>userMessageId</td>
<td>Integer</td>
<td>(M)</td>
<td>Mandatory if userMessageId is provided in the user request</td>
</tr>
</tbody>
</table>

#### Channel Fields

<table>
<thead>
<tr class="header">
<th>Name</th>
<th>Type(value)</th>
<th>Mandatory</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>type</td>
<td>trades</td>
<td>M</td>
<td></td>
</tr>
<tr class="even">
<td>time</td>
<td>Timestamp</td>
<td>M</td>
<td></td>
</tr>
<tr class="odd">
<td>tradeId</td>
<td>String</td>
<td>M</td>
<td></td>
</tr>
<tr class="even">
<td>price</td>
<td>DoubleString</td>
<td>M</td>
<td></td>
</tr>
<tr class="odd">
<td>size</td>
<td>DoubleString</td>
<td>M</td>
<td></td>
</tr>
<tr class="even">
<td>side</td>
<td>String</td>
<td>M</td>
<td>Buy/Sell</td>
</tr>
</tbody>
</table>

#### Failure Error Codes

<table>
<thead>
<tr class="header">
<th>Error Code</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td></td>
<td></td>
</tr>
</tbody>
</table>

### Charts

#### Request Fields

<table>
<thead>
<tr class="header">
<th>Attribute</th>
<th>Type(value)</th>
<th>Mandatory</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>type</td>
<td>subscribe</td>
<td>M</td>
<td>Subscribe/Unsubscribe message type</td>
</tr>
<tr class="even">
<td>channel</td>
<td>charts</td>
<td>M</td>
<td></td>
</tr>
<tr class="odd">
<td>instrumentIds</td>
<td>Array of instrumentId Strings</td>
<td>M</td>
<td></td>
</tr>
<tr class="even">
<td>userMessageId</td>
<td>Integer</td>
<td>O</td>
<td>Unique message id for this websocket session</td>
</tr>
</tbody>
</table>

#### Response Fields

<table>
<thead>
<tr class="header">
<th>Attribute</th>
<th>Type(value)</th>
<th>Mandatory</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>type</td>
<td>subscribed</td>
<td>M</td>
<td>Subscribe/Unsubscribe message type</td>
</tr>
<tr class="even">
<td>channel</td>
<td>charts</td>
<td>M</td>
<td></td>
</tr>
<tr class="odd">
<td>instrumentIds</td>
<td>Array of instrumentId Strings</td>
<td>M</td>
<td></td>
</tr>
<tr class="even">
<td>userMessageId</td>
<td>Integer</td>
<td>(M)</td>
<td>Mandatory if userMessageId is provided in the user request</td>
</tr>
</tbody>
</table>

#### Channel Fields

<table>
<thead>
<tr class="header">
<th>Name</th>
<th>Type(value)</th>
<th>Mandatory</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>type</td>
<td>charts</td>
<td>M</td>
<td></td>
</tr>
<tr class="even">
<td>startTime</td>
<td>Timestamp</td>
<td>M</td>
<td></td>
</tr>
<tr class="odd">
<td>openPrice</td>
<td>String</td>
<td>M</td>
<td></td>
</tr>
<tr class="even">
<td>closePrice</td>
<td>String</td>
<td>M</td>
<td></td>
</tr>
<tr class="odd">
<td>low</td>
<td>String</td>
<td>M</td>
<td></td>
</tr>
<tr class="even">
<td>high</td>
<td>String</td>
<td>M</td>
<td></td>
</tr>
<tr class="odd">
<td>volume</td>
<td>String</td>
<td>M</td>
<td></td>
</tr>
</tbody>
</table>

The first charts message will contain the array of historical data
entries with the size of 60.

#### Failure Error Codes

<table>
<thead>
<tr class="header">
<th>Error Code</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td></td>
<td></td>
</tr>
</tbody>
</table>

Private Channels
----------------

### New Order

#### Request Fields

<table>
<thead>
<tr class="header">
<th>Name</th>
<th>Type(value)</th>
<th>Mandatory</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>apiKey</td>
<td>String</td>
<td>M</td>
<td></td>
</tr>
<tr class="even">
<td>signature</td>
<td>String</td>
<td>M</td>
<td></td>
</tr>
<tr class="odd">
<td>passPhrase</td>
<td>String</td>
<td>M</td>
<td></td>
</tr>
<tr class="even">
<td>type</td>
<td>newOrder</td>
<td>M</td>
<td></td>
</tr>
<tr class="odd">
<td>instrumentId</td>
<td>String</td>
<td>M</td>
<td></td>
</tr>
<tr class="even">
<td>userAccount</td>
<td>String</td>
<td>M</td>
<td>User account used for this order</td>
</tr>
<tr class="odd">
<td>orderType</td>
<td>String</td>
<td>M</td>
<td>Limit/Market/Stop/StopLimit</td>
</tr>
<tr class="even">
<td>price</td>
<td>DoubleString</td>
<td>(M)</td>
<td>Mandatory if order is non Market order</td>
</tr>
<tr class="odd">
<td>size</td>
<td>DoubleString</td>
<td>(M)</td>
<td><p>Mandatory if order is non Market order</p>
<p>For Market order, the user can either provide size or amount in quote currency</p></td>
</tr>
<tr class="even">
<td>amount</td>
<td>DoubleString</td>
<td>O</td>
<td>Amount in quote currency to buy/sell</td>
</tr>
<tr class="odd">
<td>side</td>
<td>Buy/Sell</td>
<td>M</td>
<td></td>
</tr>
<tr class="even">
<td>timeInForce</td>
<td>GTC, GTT, IOC FOK</td>
<td>M</td>
<td></td>
</tr>
<tr class="odd">
<td>clientOrderId</td>
<td>String</td>
<td>O</td>
<td></td>
</tr>
<tr class="even">
<td>stopPrice</td>
<td>NumberString</td>
<td>(M)</td>
<td>Mandatory if orderType is Stop or StopLimit</td>
</tr>
<tr class="odd">
<td>postOnly</td>
<td>Boolean</td>
<td>O</td>
<td>Default to false. If any part of the order results in taking liquidity, the order will be rejected and no part of it will execute.</td>
</tr>
<tr class="even">
<td>selfTradePrevention</td>
<td>String</td>
<td>O</td>
<td><p>Decrease and cancel (Default)</p>
<p>Cancel oldest;</p>
<p>Cancel newest;</p>
<p>Cancel both;</p></td>
</tr>
<tr class="odd">
<td>userMessageId</td>
<td>Integer</td>
<td>O</td>
<td>Unique message id for this websocket session</td>
</tr>
</tbody>
</table>

#### Failure Error Codes

<table>
<thead>
<tr class="header">
<th>Error Code</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td></td>
<td></td>
</tr>
</tbody>
</table>

### Cancel Order

#### Request Fields

<table>
<thead>
<tr class="header">
<th>Name</th>
<th>Type(value)</th>
<th>Mandatory</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>apiKey</td>
<td>String</td>
<td>M</td>
<td></td>
</tr>
<tr class="even">
<td>signature</td>
<td>String</td>
<td>M</td>
<td></td>
</tr>
<tr class="odd">
<td>passPhrase</td>
<td>String</td>
<td>M</td>
<td></td>
</tr>
<tr class="even">
<td>type</td>
<td>cancelOrder</td>
<td>M</td>
<td></td>
</tr>
<tr class="odd">
<td>orderId</td>
<td>String</td>
<td>(M)</td>
<td></td>
</tr>
<tr class="even">
<td>clientOrderId</td>
<td>String</td>
<td>(M)</td>
<td></td>
</tr>
<tr class="odd">
<td>userMessageId</td>
<td>Integer</td>
<td>O</td>
<td>Unique message id for this websocket session</td>
</tr>
</tbody>
</table>

#### Failure Error Codes

<table>
<thead>
<tr class="header">
<th>Error Code</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td></td>
<td></td>
</tr>
</tbody>
</table>

### Order Update

#### Request Fields

<table>
<thead>
<tr class="header">
<th>Name</th>
<th>Type(value)</th>
<th>Mandatory</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>apiKey</td>
<td>String</td>
<td>M</td>
<td></td>
</tr>
<tr class="even">
<td>signature</td>
<td>String</td>
<td>M</td>
<td></td>
</tr>
<tr class="odd">
<td>passPhrase</td>
<td>String</td>
<td>M</td>
<td></td>
</tr>
<tr class="even">
<td>type</td>
<td>subscribe</td>
<td>M</td>
<td>Subscribe/Unsubscribe message type</td>
</tr>
<tr class="odd">
<td>channel</td>
<td>orderUpdate</td>
<td>M</td>
<td></td>
</tr>
<tr class="even">
<td>instrumentIds</td>
<td>Array of instrumentId Strings</td>
<td>O</td>
<td>Subscribe/Unsubscribe all instruments by default</td>
</tr>
<tr class="odd">
<td>numberOfSnapshotRecords</td>
<td>Integer</td>
<td>O</td>
<td>Max recent number of open orders returned. All open orders will be returned if not specified.</td>
</tr>
<tr class="even">
<td>userMessageId</td>
<td>Integer</td>
<td>O</td>
<td>Unique message id for this websocket session</td>
</tr>
</tbody>
</table>

#### Response Fields

<table>
<thead>
<tr class="header">
<th>Attribute</th>
<th>Type(value)</th>
<th>Mandatory</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>type</td>
<td>subscribed</td>
<td>M</td>
<td>Subscribe/Unsubscribe message type</td>
</tr>
<tr class="even">
<td>channel</td>
<td>orderUpdate</td>
<td>M</td>
<td></td>
</tr>
<tr class="odd">
<td>instrumentIds</td>
<td>Array of instrumentId Strings</td>
<td>O</td>
<td>Subscribed/Unsubscribed for all instruments by default</td>
</tr>
<tr class="even">
<td>openOrders</td>
<td>Array of orders Json Fields</td>
<td>M</td>
<td></td>
</tr>
<tr class="odd">
<td>userMessageId</td>
<td>Integer</td>
<td>(M)</td>
<td>Mandatory if userMessageId is provided in the user request</td>
</tr>
</tbody>
</table>

#### Channel Fields

<table>
<thead>
<tr class="header">
<th>Name</th>
<th>Type(value)</th>
<th>Mandatory</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>type</td>
<td>orderUpdate</td>
<td>M</td>
<td></td>
</tr>
<tr class="even">
<td>orderId</td>
<td>String</td>
<td>M</td>
<td></td>
</tr>
<tr class="odd">
<td>subaccount</td>
<td>String</td>
<td>M</td>
<td></td>
</tr>
<tr class="even">
<td>instrumentId</td>
<td>String</td>
<td>M</td>
<td></td>
</tr>
<tr class="odd">
<td>type</td>
<td>Market, Limit, Stop, StopLimit</td>
<td>M</td>
<td></td>
</tr>
<tr class="even">
<td>price</td>
<td>DoubleString</td>
<td>M</td>
<td></td>
</tr>
<tr class="odd">
<td>size</td>
<td>DoubleString</td>
<td>M</td>
<td></td>
</tr>
<tr class="even">
<td>side</td>
<td>Buy/Sell</td>
<td>M</td>
<td></td>
</tr>
<tr class="odd">
<td>timeInForce</td>
<td>GTC, GTT, IOC, FOK</td>
<td>M</td>
<td></td>
</tr>
<tr class="even">
<td>orderTime</td>
<td>Timestamp</td>
<td>M</td>
<td></td>
</tr>
<tr class="odd">
<td>stopPrice</td>
<td>DoubleString</td>
<td>O</td>
<td></td>
</tr>
<tr class="even">
<td>status</td>
<td><p>Open,</p>
<p>Partially Filled, Filled, Cancelled</p></td>
<td>M</td>
<td></td>
</tr>
<tr class="odd">
<td>executedSize</td>
<td>DoubleString</td>
<td>O</td>
<td></td>
</tr>
<tr class="even">
<td>executedPrice</td>
<td>DoubleString</td>
<td>O</td>
<td></td>
</tr>
<tr class="odd">
<td>postLiquidity</td>
<td>Boolean</td>
<td>M</td>
<td>True – order rest in the book initially</td>
</tr>
<tr class="even">
<td>fee</td>
<td>DoubleString</td>
<td>O</td>
<td></td>
</tr>
<tr class="odd">
<td>selfTradePrevention</td>
<td>String</td>
<td>M</td>
<td><p>DC – Decrease and cancel</p>
<p>CO – Cancel oldest</p>
<p>CN – Cancel newest</p>
<p>CB – Cancel both</p></td>
</tr>
<tr class="even">
<td>clientOrderId</td>
<td>String</td>
<td>O</td>
<td></td>
</tr>
</tbody>
</table>

#### Failure Error Codes

<table>
<thead>
<tr class="header">
<th>Error Code</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td></td>
<td></td>
</tr>
</tbody>
</table>

### Account Update

#### Request Fields

<table>
<thead>
<tr class="header">
<th>Attribute</th>
<th>Type(value)</th>
<th>Mandatory</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>apiKey</td>
<td>String</td>
<td>M</td>
<td></td>
</tr>
<tr class="even">
<td>signature</td>
<td>String</td>
<td>M</td>
<td></td>
</tr>
<tr class="odd">
<td>type</td>
<td>subscribe</td>
<td>M</td>
<td>Subscribe/Unsubscribe message type</td>
</tr>
<tr class="even">
<td>channel</td>
<td>accountUpdate</td>
<td>M</td>
<td></td>
</tr>
<tr class="odd">
<td>currencies</td>
<td>Array of currency Strings</td>
<td>O</td>
<td>Subscribe for all currencies by default</td>
</tr>
<tr class="even">
<td>numberOfRecentTransactions</td>
<td>Integer</td>
<td>O</td>
<td>Default to 100</td>
</tr>
<tr class="odd">
<td>userMessageId</td>
<td>Integer</td>
<td>O</td>
<td>Unique message id for this websocket session</td>
</tr>
</tbody>
</table>

#### Response Fields

<table>
<thead>
<tr class="header">
<th>Name</th>
<th>Type(value)</th>
<th>Mandatory</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>type</td>
<td>subscribed</td>
<td>M</td>
<td>Subscribe/Unsubscribe message type</td>
</tr>
<tr class="even">
<td>channel</td>
<td>accounts</td>
<td>M</td>
<td></td>
</tr>
<tr class="odd">
<td>currencies</td>
<td>Array of currency Strings</td>
<td>O</td>
<td></td>
</tr>
<tr class="even">
<td>accountBalances</td>
<td>Array of account balances (accountId, currency, balance, availableBalance)</td>
<td>M</td>
<td></td>
</tr>
<tr class="odd">
<td>recentAccountUpdates</td>
<td>Array of recent accountUpdate Json fields</td>
<td>M</td>
<td></td>
</tr>
<tr class="even">
<td>userMessageId</td>
<td>Integer</td>
<td>(M)</td>
<td>Mandatory if userMessageId is provided in the user request</td>
</tr>
</tbody>
</table>

#### Channel Fields

<table>
<thead>
<tr class="header">
<th>Name</th>
<th>Type(value)</th>
<th>Mandatory</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>type</td>
<td>accountUpdate</td>
<td>M</td>
<td></td>
</tr>
<tr class="even">
<td>userAccount</td>
<td>String</td>
<td>M</td>
<td></td>
</tr>
<tr class="odd">
<td>transactionId</td>
<td>String</td>
<td>M</td>
<td></td>
</tr>
<tr class="even">
<td>accountId</td>
<td>String</td>
<td>M</td>
<td></td>
</tr>
<tr class="odd">
<td>currency</td>
<td>String</td>
<td>M</td>
<td></td>
</tr>
<tr class="even">
<td>transactionType</td>
<td>String</td>
<td>M</td>
<td>Trade/Deposit/Withdraw/Fee/Rebate/Order/PendingWithdraw</td>
</tr>
<tr class="odd">
<td>amount</td>
<td>DoubleString</td>
<td>M</td>
<td></td>
</tr>
<tr class="even">
<td>balance</td>
<td>DoubleString</td>
<td>M</td>
<td></td>
</tr>
<tr class="odd">
<td>available</td>
<td>DoubleString</td>
<td>M</td>
<td></td>
</tr>
<tr class="even">
<td>timestamp</td>
<td>Timestamp</td>
<td>M</td>
<td></td>
</tr>
<tr class="odd">
<td>referenceId</td>
<td>String</td>
<td>M</td>
<td><p>Additional information</p>
<p>Trade – {tradeId}</p>
<p>Withdraw – {withdrawId}</p>
<p>Fee – {tradeId or withdrawId}</p>
<p>Order – {orderId}</p>
<p>WithdrawRequest – {withdrawId}</p></td>
</tr>
</tbody>
</table>

#### Failure Error Codes

<table>
<thead>
<tr class="header">
<th>Error Code</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td></td>
<td></td>
</tr>
</tbody>
</table>

Site UI only API
================

Public Endpoints
----------------

### User Registration

POST /api/public/register

#### Request Parameters

<table>
<thead>
<tr class="header">
<th>Name</th>
<th>Type(value)</th>
<th>Mandatory</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>username</td>
<td>String</td>
<td>O</td>
<td>email as default</td>
</tr>
<tr class="even">
<td>email</td>
<td>String</td>
<td>M</td>
<td></td>
</tr>
<tr class="odd">
<td>Password</td>
<td>String</td>
<td>M</td>
<td>Secured password</td>
</tr>
</tbody>
</table>

#### Success Response Body Fields

<table>
<thead>
<tr class="header">
<th>Name</th>
<th>Type(value)</th>
<th>Mandatory</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>registrationStatus</td>
<td>“true”</td>
<td>M</td>
<td>email as default</td>
</tr>
<tr class="even">
<td>messageCode</td>
<td>“CHECK_EMAIL_TO_CONFIRM”</td>
<td>M</td>
<td>Check email to confirm the registration</td>
</tr>
</tbody>
</table>

#### Failure Error Codes

<table>
<thead>
<tr class="header">
<th>Error Code</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>USERNAME_IN_USE</td>
<td>User name has been in use</td>
</tr>
<tr class="even">
<td>EMAIL_IN_USE</td>
<td>User with the same email has already been registered and is active.</td>
</tr>
<tr class="odd">
<td>EMAIL_REGISTERED_NON_ACTIVE</td>
<td>User with the same email has already been registered, but is not active.</td>
</tr>
<tr class="even">
<td>BAD_PASSWORD</td>
<td>Provided password does not meet the requirements</td>
</tr>
<tr class="odd">
<td></td>
<td></td>
</tr>
</tbody>
</table>

### User Login

POST /api/public/login

#### Request Parameters

<table>
<thead>
<tr class="header">
<th>Name</th>
<th>Type(value)</th>
<th>Mandatory</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>username</td>
<td>String</td>
<td>(M)</td>
<td>User either provide username or email</td>
</tr>
<tr class="even">
<td>email</td>
<td>String</td>
<td>(M)</td>
<td></td>
</tr>
<tr class="odd">
<td>password</td>
<td>String</td>
<td>M</td>
<td></td>
</tr>
</tbody>
</table>

#### Success Response Body Fields

<table>
<thead>
<tr class="header">
<th>Name</th>
<th>Type(value)</th>
<th>Mandatory</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>sessionToken</td>
<td>String</td>
<td>M</td>
<td></td>
</tr>
</tbody>
</table>

#### Failure Error Codes

<table>
<thead>
<tr class="header">
<th>Error Code</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td></td>
<td></td>
</tr>
</tbody>
</table>

### Get Security Question List

GET /api/public/securityQuestions

#### Success Response Body Fields

<table>
<thead>
<tr class="header">
<th>Name</th>
<th>Type(value)</th>
<th>Mandatory</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>securityQuestions</td>
<td>An array of Strings</td>
<td>M</td>
<td>e.g. [“What is the name of your favorite movie”]</td>
</tr>
</tbody>
</table>

#### Failure Error Codes

<table>
<thead>
<tr class="header">
<th>Error Code</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td></td>
<td></td>
</tr>
</tbody>
</table>

### Reset Password

POST /api/public/resetPassword

#### Request Parameters

<table>
<thead>
<tr class="header">
<th>Name</th>
<th>Type(value)</th>
<th>Mandatory</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>username</td>
<td>String</td>
<td>(M)</td>
<td>User either provide username or email</td>
</tr>
<tr class="even">
<td>email</td>
<td>String</td>
<td>(M)</td>
<td></td>
</tr>
<tr class="odd">
<td>securityAnswers</td>
<td>An array of Json objects</td>
<td>M</td>
<td>e.g. [{“What is the name of your favorite movie”:”Forrest Gump”}]</td>
</tr>
</tbody>
</table>

#### Failure Error Codes

<table>
<thead>
<tr class="header">
<th>Error Code</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td></td>
<td></td>
</tr>
</tbody>
</table>

### Resend Email Confirmation

#### Request Parameters

<table>
<thead>
<tr class="header">
<th>Name</th>
<th>Type(value)</th>
<th>Mandatory</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>email</td>
<td>String</td>
<td>M</td>
<td></td>
</tr>
</tbody>
</table>

#### Failure Error Codes

<table>
<thead>
<tr class="header">
<th>Error Code</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>EMAIL_IN_USE</td>
<td>User with the same email has already been registered and is active.</td>
</tr>
<tr class="even">
<td></td>
<td></td>
</tr>
</tbody>
</table>

Private Endpoints
-----------------

All requests to private endpoints require authentication. For each REST
call, AUTH\_TOKEN should be encoded in HTTP headers. All private calls
that are available through provided apiKey are also available with
provided sessionToken. In addition, all request parameters can include
userAccount as an optional field to query or send request for the
specified account only.

### Deposit

POST /api/private/desposit/{currency}

#### Success Response Body Fields

<table>
<thead>
<tr class="header">
<th>Name</th>
<th>Type(value)</th>
<th>Mandatory</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>currency</td>
<td>String</td>
<td>M</td>
<td></td>
</tr>
<tr class="even">
<td>address</td>
<td>String</td>
<td>(M)</td>
<td>Mandatory if currency is non-fiat currency</td>
</tr>
<tr class="odd">
<td>despositInstruction</td>
<td>A Json Object</td>
<td>(M)</td>
<td>Mandatory is currency is fiat currency</td>
</tr>
</tbody>
</table>

#### Failure Error Codes

<table>
<thead>
<tr class="header">
<th>Error Code</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td></td>
<td></td>
</tr>
</tbody>
</table>

### Update Profile

POST /api/private/updateProfile

#### Request Parameters

<table>
<thead>
<tr class="header">
<th>Name</th>
<th>Type(value)</th>
<th>Mandatory</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>email</td>
<td>String</td>
<td>O</td>
<td></td>
</tr>
<tr class="even">
<td>username</td>
<td>String</td>
<td>O</td>
<td></td>
</tr>
<tr class="odd">
<td>oldPassword</td>
<td>String</td>
<td>(M)</td>
<td>Mandatory if newPassword is provided</td>
</tr>
<tr class="even">
<td>newPassword</td>
<td>String</td>
<td>O</td>
<td></td>
</tr>
</tbody>
</table>

#### Failure Error Codes

<table>
<thead>
<tr class="header">
<th>Error Code</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td></td>
<td></td>
</tr>
</tbody>
</table>

### Create New API Key

POST /api/private/apiKeys/new

#### Request Parameters

<table>
<thead>
<tr class="header">
<th>Name</th>
<th>Type(value)</th>
<th>Mandatory</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>name</td>
<td>String</td>
<td>M</td>
<td></td>
</tr>
<tr class="even">
<td>permissions</td>
<td>A JSON object</td>
<td>M</td>
<td>e.g. {“accounts”:{“read”: true, “write”: “false”}, “orders”:{“read”: “true”, “write”:”true”}}</td>
</tr>
<tr class="odd">
<td>userAccount</td>
<td>String</td>
<td>O</td>
<td>associated user account</td>
</tr>
</tbody>
</table>

#### Success Response Body Fields

<table>
<thead>
<tr class="header">
<th>Name</th>
<th>Type(value)</th>
<th>Mandatory</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>name</td>
<td>String</td>
<td>M</td>
<td></td>
</tr>
<tr class="even">
<td>apiKey</td>
<td>String</td>
<td>M</td>
<td></td>
</tr>
<tr class="odd">
<td>secret</td>
<td>String</td>
<td>M</td>
<td></td>
</tr>
</tbody>
</table>

#### Failure Error Codes

<table>
<thead>
<tr class="header">
<th>Error Code</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td></td>
<td></td>
</tr>
</tbody>
</table>

### Get API Keys

GET /api/private/apiKeys

#### Success Response Body Fields

<table>
<thead>
<tr class="header">
<th>Name</th>
<th>Type(value)</th>
<th>Mandatory</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>keys</td>
<td>An array of Json Objects with apiKey, userAccount and permissions</td>
<td>M</td>
<td>e.g. [{“key”:”bot”, “userAccount”:”main”, “permissions”: {“accounts”:{“read”: true, “write”: “false”}, “orders”:{“read”: “true”, “write”:”true”}}}]</td>
</tr>
</tbody>
</table>

### Delete API Key

DELETE /api/private/apiKeys/{apiKey name}

#### Failure Error Codes

<table>
<thead>
<tr class="header">
<th>Error Code</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td></td>
<td></td>
</tr>
</tbody>
</table>

### Enable Google Authenticator

POST /api/private/enableAuthenticator

#### Success Response Body Fields

<table>
<thead>
<tr class="header">
<th>Name</th>
<th>Type(value)</th>
<th>Mandatory</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>seed</td>
<td>String</td>
<td>M</td>
<td></td>
</tr>
</tbody>
</table>

#### Failure Error Codes

<table>
<thead>
<tr class="header">
<th>Error Code</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td></td>
<td></td>
</tr>
</tbody>
</table>

### Get KYC Requirements

GET /api/private/kycRequirements

#### Success Response Body Fields

<table>
<thead>
<tr class="header">
<th>Name</th>
<th>Type(value)</th>
<th>Mandatory</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>requiredFields</td>
<td>A Json Object String</td>
<td>M</td>
<td></td>
</tr>
<tr class="even">
<td>requiredFiles</td>
<td>Array of Strings</td>
<td>M</td>
<td>e.g. [“ID”, “Proof of Address”, “Proof of ID Holder”]</td>
</tr>
</tbody>
</table>

#### Failure Error Codes

<table>
<thead>
<tr class="header">
<th>Error Code</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td></td>
<td></td>
</tr>
</tbody>
</table>

### Submit KYC Request

#### Request Parameters

<table>
<thead>
<tr class="header">
<th>Name</th>
<th>Type(value)</th>
<th>Mandatory</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>requiredFields</td>
<td>A Json Object String</td>
<td>M</td>
<td></td>
</tr>
<tr class="even">
<td>requiredFiles</td>
<td>A JSON object</td>
<td>M</td>
<td></td>
</tr>
</tbody>
</table>

### Create New User Account

POST /api/private/userAccounts /new

#### Request Parameters

<table>
<thead>
<tr class="header">
<th>Name</th>
<th>Type(value)</th>
<th>Mandatory</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>name</td>
<td>String</td>
<td>M</td>
<td></td>
</tr>
</tbody>
</table>

#### Failure Error Codes

<table>
<thead>
<tr class="header">
<th>Error Code</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td></td>
<td></td>
</tr>
</tbody>
</table>

### Get User Accounts

GET /api/private/userAccounts

#### Success Response Body Fields

<table>
<thead>
<tr class="header">
<th>Name</th>
<th>Type(value)</th>
<th>Mandatory</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>userAccounts</td>
<td>Array of Strings</td>
<td>M</td>
<td>List of userAccounts associated with this user</td>
</tr>
</tbody>
</table>

### Delete User Account

DELETE /api/private/userAccounts/{userAccount name}

#### Failure Error Codes

<table>
<thead>
<tr class="header">
<th>Error Code</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td></td>
<td></td>
</tr>
</tbody>
</table>

### Add Bank Account

#### Request Parameters

<table>
<thead>
<tr class="header">
<th>Name</th>
<th>Type(value)</th>
<th>Mandatory</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>name</td>
<td>String</td>
<td>M</td>
<td></td>
</tr>
<tr class="even">
<td>owner</td>
<td>String</td>
<td>M</td>
<td></td>
</tr>
<tr class="odd">
<td>accountNumber</td>
<td>String</td>
<td>M</td>
<td></td>
</tr>
<tr class="even">
<td>bankAddress</td>
<td>String</td>
<td>M</td>
<td></td>
</tr>
<tr class="odd">
<td>swiftCode</td>
<td>String</td>
<td>M</td>
<td></td>
</tr>
</tbody>
</table>

#### Success Response Body Fields

<table>
<thead>
<tr class="header">
<th>Name</th>
<th>Type(value)</th>
<th>Mandatory</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>bankId</td>
<td>String</td>
<td>M</td>
<td></td>
</tr>
</tbody>
</table>

#### Failure Error Codes

<table>
<thead>
<tr class="header">
<th>Error Code</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td></td>
<td></td>
</tr>
</tbody>
</table>

### Get Bank Accounts

GET /api/private/bankAccounts

#### Success Response Body Fields

<table>
<thead>
<tr class="header">
<th>Name</th>
<th>Type(value)</th>
<th>Mandatory</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>bankAccounts</td>
<td>Array of Json Objects</td>
<td>M</td>
<td>List of userAccounts associated with this user. e.g. [{“bankId”:”xxxx”, “name”:”xxx”, “owner”:”xxxx”, “accountNumber”:”xxxx”, “bankAddress”:”xxxx”, “swiftCode”:”xxxx”}]</td>
</tr>
</tbody>
</table>

### Delete Bank Account

DELETE /api/private/userAccounts/{bank account id}
