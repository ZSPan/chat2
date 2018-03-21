# MIQS Exchange Solution WEB API

[**Overview**](#overview)

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[Message Format](#message-format)

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[Message Field Types](#message-field-types)

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[Mandatory Field Indicators](#mandatory-field-indicators)

[**REST API**](#rest-api)

&nbsp;&nbsp;&nbsp;&nbsp;[***General Information***](#general-information)

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[Success Response](#success-response)

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[Error Response](#error-response)

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[Pagination](#pagination)

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[Rate Limits](#rate-limits)

&nbsp;&nbsp;&nbsp;&nbsp;[***Public Endpoints***](#public-endpoints)

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[Instruments](#instruments)

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[Ticker](#ticker)

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[Order Book](#order-book)

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[Trades](#trades)

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[Charts](#charts)

&nbsp;&nbsp;&nbsp;&nbsp;[***Private Endpoints***](#private-endpoints)

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[Orders](#orders)

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[OwnTrades](#owntrades)

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[New Order](#new-order)

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[Cancel Order](#cancel-order)

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[Cancel All Order](#cancel-all-order)

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[Accounts](#accounts)

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[Account Transactions](#account-transactions)

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[Withdraw](#withdraw)

[**WEBSOCKET API**](#websocket-api)

&nbsp;&nbsp;&nbsp;&nbsp;[***General Information***](#general-information-1)

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[Error Fields](#error-fields)

&nbsp;&nbsp;&nbsp;&nbsp;[***Public Channels***](#public-channels)

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[Ticker](#ticker-1)

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[Order Book](#order-book-1)

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[Full Order Book channel](#full-order-book-channel)

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[Trades](#trades-1)

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[Charts](#charts-1)

&nbsp;&nbsp;&nbsp;&nbsp;[***Private Channels***](#private-channels)

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[New Order](#new-order-1)

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[Cancel Order](#cancel-order-1)

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[Order Update](#order-update)

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[Account Update](#account-update)

[**Site UI only API**](#site-ui-only-api)

&nbsp;&nbsp;&nbsp;&nbsp;[***Public Endpoints***](#public-endpoints-1)

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[User Registration](#user-registration)

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[User Login](#user-login)

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[Get Security Question List](#get-security-question-list)

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[Reset Password](#reset-password)

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[Resend Email Confirmation](#resend-email-confirmation)

&nbsp;&nbsp;&nbsp;&nbsp;[***Private Endpoints***](#private-endpoints-1)

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[Deposit](#deposit)

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[Update Profile](#update-profile)

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[Create New API Key](#create-new-api-key)

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[Get API Keys](#get-api-keys)

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[Delete API Key](#delete-api-key)

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[Enable Google Authenticator](#enable-google-authenticator)

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[Get KYC Requirements](#get-kyc-requirements)

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[Submit KYC Request](#submit-kyc-request)

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[Create New User Account](#create-new-user-account)

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[Get User Accounts](#get-user-accounts)

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[Delete User Account](#delete-user-account)

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[Add Bank Account](#add-bank-account)

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[Get Bank Accounts](#get-bank-accounts)

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[Delete Bank Account](#delete-bank-account)

<a name="overview" id="overview"> </a>

Overview
========

The Secure Web API allows client applications to view and update data
using the HTTPS protocol over the internet. The purpose of this document
is to provide the spec on the messages communicated through WEB API.

<a name="message-format" id="message-format"> </a>

### Message Format

All messages are in json format.

<a name="message-field-types" id="message-field-types"> </a>

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

<a name="mandatory-field-indicators" id="mandatory-field-indicators"> </a>

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

<a name="rest-api" id="rest-api"> </a>

REST API
========

<https://www.xxxx.com/api>

<a name="general-information" id="general-information"> </a>

General Information
-------------------

All requests and responses use application/json content type. Responses
follow HTTP response status codes to indicate the success and the
failure.

<a name="success-response" id="success-response"> </a>

### Success Response

Successful http response contains HTTP status code 200 and an optional
body. If the response contains the body, the fields within the body are
documented in each related sections.

<a name="error-response" id="error-response"> </a>

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

<a name="pagination" id="pagination"> </a>

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

<a name="rate-limits" id="rate-limits"> </a>

### Rate Limits

Throttle public endpoints by IP: x requests per second

Throttle private endpoints by user ID: x requests per second

<a name="public-endpoints" id="public-endpoints"> </a>

Public Endpoints
----------------

<a name="instruments" id="instruments"> </a>

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

<a name="ticker" id="ticker"> </a>

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

<a name="order-book" id="order-book"> </a>

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

<a name="trades" id="trades"> </a>

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

<a name="charts" id="charts"> </a>

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

<a name="private-endpoints" id="private-endpoints"> </a>

Private Endpoints
-----------------

All requests to private endpoints require authentication. For each REST
call, API\_KEY, SIGNATURE and NONCE should be encoded in HTTP headers.

<a name="orders" id="orders"> </a>

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

<a name="owntrades" id="owntrades"> </a>

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

<a name="new-order" id="new-order"> </a>

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

<a name="cancel-order" id="cancel-order"> </a>

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

<a name="cancel-all-order" id="cancel-all-order"> </a>

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

<a name="accounts" id="accounts"> </a>

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

<a name="account-transactions" id="account-transactions"> </a>

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

<a name="withdraw" id="withdraw"> </a>

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

<a name="websocket-api" id="websocket-api"> </a>

WEBSOCKET API
=============

wss://ws-api.xxxx.com

<a name="general-information-1" id="general-information-1"> </a>

General Information
-------------------

All messages sent and received through websocket are encoded in JSON
format. All messages have a **type** attribute that can be used to
handle the message.

<a name="error-fields" id="error-fields"> </a>

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

<a name="public-channels" id="public-channels"> </a>

Public Channels
---------------

<a name="ticker-1" id="ticker-1"> </a>

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

<a name="order-book-1" id="order-book-1"> </a>

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

<a name="full-order-book-channel" id="full-order-book-channel"> </a>

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

<a name="trades-1" id="trades-1"> </a>

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

<a name="charts-1" id="charts-1"> </a>

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

<a name="private-channels" id="private-channels"> </a>

Private Channels
----------------

<a name="new-order-1" id="new-order-1"> </a>

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

<a name="cancel-order-1" id="cancel-order-1"> </a>

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

<a name="order-update" id="order-update"> </a>

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

<a name="account-update" id="account-update"> </a>

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

<a name="site-ui-only-api" id="site-ui-only-api"> </a>

Site UI only API
================

<a name="public-endpoints-1" id="public-endpoints-1"> </a>

Public Endpoints
----------------

<a name="user-registration" id="user-registration"> </a>

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

<a name="user-login" id="user-login"> </a>

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

<a name="get-security-question-list" id="get-security-question-list"> </a>

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

<a name="reset-password" id="reset-password"> </a>

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

<a name="resend-email-confirmation" id="resend-email-confirmation"> </a>

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

<a name="private-endpoints-1" id="private-endpoints-1"> </a>

Private Endpoints
-----------------

All requests to private endpoints require authentication. For each REST
call, AUTH\_TOKEN should be encoded in HTTP headers. All private calls
that are available through provided apiKey are also available with
provided sessionToken. In addition, all request parameters can include
userAccount as an optional field to query or send request for the
specified account only.

<a name="deposit" id="deposit"> </a>

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

<a name="update-profile" id="update-profile"> </a>

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

<a name="create-new-api-key" id="create-new-api-key"> </a>

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

<a name="get-api-keys" id="get-api-keys"> </a>

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

<a name="delete-api-key" id="delete-api-key"> </a>

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

<a name="enable-google-authenticator" id="enable-google-authenticator"> </a>

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

<a name="get-kyc-requirements" id="get-kyc-requirements"> </a>

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

<a name="submit-kyc-request" id="submit-kyc-request"> </a>

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

<a name="create-new-user-account" id="create-new-user-account"> </a>

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

<a name="get-user-accounts" id="get-user-accounts"> </a>

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

<a name="delete-user-account" id="delete-user-account"> </a>

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

<a name="add-bank-account" id="add-bank-account"> </a>

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

<a name="get-bank-accounts" id="get-bank-accounts"> </a>

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

<a name="delete-bank-account" id="delete-bank-account"> </a>

### Delete Bank Account

DELETE /api/private/userAccounts/{bank account id}
