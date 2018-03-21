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
<td style="border: 1px solid #dfe2e5;">Timestamp</td>
<td style="border: 1px solid #dfe2e5;"></td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">Integer</td>
<td style="border: 1px solid #dfe2e5;">Without quote around the number</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">Boolean</td>
<td style="border: 1px solid #dfe2e5;">True/False</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">DoubleString</td>
<td style="border: 1px solid #dfe2e5;">Double number quoted as a String</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">LongString</td>
<td style="border: 1px solid #dfe2e5;">Long number quoted as a String</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;"></td>
<td style="border: 1px solid #dfe2e5;"></td>
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
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;">This field is mandatory</td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">(M)</td>
<td style="border: 1px solid #dfe2e5;">This field is mandatory under certain conditions</td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">O</td>
<td style="border: 1px solid #dfe2e5;">This field is optional</td>
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
<td style="border: 1px solid #dfe2e5;">errorCode</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">Error code. e.g. INVALID_PASSWORD</td>
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
<td style="border: 1px solid #dfe2e5;">pageNumber</td>
<td style="border: 1px solid #dfe2e5;">Integer</td>
<td style="border: 1px solid #dfe2e5;">O</td>
<td style="border: 1px solid #dfe2e5;">Default to 1</td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">pageSize</td>
<td style="border: 1px solid #dfe2e5;">Integer</td>
<td style="border: 1px solid #dfe2e5;">O</td>
<td style="border: 1px solid #dfe2e5;">Default to 100</td>
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
<td style="border: 1px solid #dfe2e5;">instrumentId</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">O</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">productType</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">O</td>
<td style="border: 1px solid #dfe2e5;">Spot/Futures/Indexes</td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">symbol</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">O</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">quoteCurrency</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">O</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">underlying</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">O</td>
<td style="border: 1px solid #dfe2e5;"></td>
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
<td style="border: 1px solid #dfe2e5;">instrumentId</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;">e.g. BTCUSD</td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">symbol</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;">e.g. BTC</td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">quoteCurrency</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;">e.g. USD</td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">productType</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;">Spot/Futures/Indexes</td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">tickSize</td>
<td style="border: 1px solid #dfe2e5;">DoubleString</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;">e.g. 0.01</td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">lotSize</td>
<td style="border: 1px solid #dfe2e5;">Integer</td>
<td style="border: 1px solid #dfe2e5;">(M)</td>
<td style="border: 1px solid #dfe2e5;">Mandatory for tradable Spot and Futures instruments e.g. 1</td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">minOrderSize</td>
<td style="border: 1px solid #dfe2e5;">DoubleString</td>
<td style="border: 1px solid #dfe2e5;">(M)</td>
<td style="border: 1px solid #dfe2e5;">Mandatory for tradable Spot and Futures instruments</td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">maxOrderSize</td>
<td style="border: 1px solid #dfe2e5;">DoubleString</td>
<td style="border: 1px solid #dfe2e5;">(M)</td>
<td style="border: 1px solid #dfe2e5;">Mandatory for tradable Spot and Futures instruments</td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">expiry</td>
<td style="border: 1px solid #dfe2e5;">Timestamp</td>
<td style="border: 1px solid #dfe2e5;">(M)</td>
<td style="border: 1px solid #dfe2e5;">Mandatory for futures instrument</td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">underlying</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">(M)</td>
<td style="border: 1px solid #dfe2e5;">Mandatory for futures instrument</td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">contractMultipler</td>
<td style="border: 1px solid #dfe2e5;">Integer</td>
<td style="border: 1px solid #dfe2e5;">(M)</td>
<td style="border: 1px solid #dfe2e5;">Mandatory for futures instrument</td>
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
<td style="border: 1px solid #dfe2e5;"></td>
<td style="border: 1px solid #dfe2e5;"></td>
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
<td style="border: 1px solid #dfe2e5;">instrumentId</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;">e.g. “BTCUSD”</td>
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
<td style="border: 1px solid #dfe2e5;">instrumentId</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;">e.g. “BTCUSD”</td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">time</td>
<td style="border: 1px solid #dfe2e5;">Timestamp</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">lastPrice</td>
<td style="border: 1px solid #dfe2e5;">DoubleString</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">bestBid</td>
<td style="border: 1px solid #dfe2e5;">DoubleString</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">bestAsk</td>
<td style="border: 1px solid #dfe2e5;">DoubleString</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">24hHigh</td>
<td style="border: 1px solid #dfe2e5;">DoubleString</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">24hLow</td>
<td style="border: 1px solid #dfe2e5;">DoubleString</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">24hVolume</td>
<td style="border: 1px solid #dfe2e5;">LongString</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">24hChange</td>
<td style="border: 1px solid #dfe2e5;">DoubleString</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
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
<td style="border: 1px solid #dfe2e5;"></td>
<td style="border: 1px solid #dfe2e5;"></td>
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
<td style="border: 1px solid #dfe2e5;">instrumentId</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;">e.g. “BTCUSD”</td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">level</td>
<td style="border: 1px solid #dfe2e5;">Integer</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"><p>1 - top bid and ask</p>
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
<td style="border: 1px solid #dfe2e5;">instrumentId</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">level</td>
<td style="border: 1px solid #dfe2e5;">1/2/3</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">sequence</td>
<td style="border: 1px solid #dfe2e5;">LongString</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">bids</td>
<td style="border: 1px solid #dfe2e5;">Array of [price, size, numOfOrders/orderId]</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"><p>Level 1 – This is one sized array</p>
<p>Level 2 – The aggregated size for each price level is returned with numOfOrders count for the price</p>
<p>Level 3 – The order level information is returned</p></td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">asks</td>
<td style="border: 1px solid #dfe2e5;">Array of [price, size, numOfOrders/orderId]</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"><p>Level 1 – This is one sized array</p>
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
<td style="border: 1px solid #dfe2e5;"></td>
<td style="border: 1px solid #dfe2e5;"></td>
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
<td style="border: 1px solid #dfe2e5;">instrumentId</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
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
<td style="border: 1px solid #dfe2e5;">time</td>
<td style="border: 1px solid #dfe2e5;">Timestamp</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">tradeId</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">price</td>
<td style="border: 1px solid #dfe2e5;">DoubleString</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">size</td>
<td style="border: 1px solid #dfe2e5;">DoubleString</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">side</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;">Buy/Sell</td>
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
<td style="border: 1px solid #dfe2e5;"></td>
<td style="border: 1px solid #dfe2e5;"></td>
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
<td style="border: 1px solid #dfe2e5;">instrumentId</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">startTime</td>
<td style="border: 1px solid #dfe2e5;">Timestamp</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">endTime</td>
<td style="border: 1px solid #dfe2e5;">Timestamp</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">granularity</td>
<td style="border: 1px solid #dfe2e5;">Integer</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"><p>In seconds; 60/300/900/3600/21600/86400;</p>
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
<td style="border: 1px solid #dfe2e5;">startTime</td>
<td style="border: 1px solid #dfe2e5;">Timestamp</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">endTime</td>
<td style="border: 1px solid #dfe2e5;">Timestamp</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">openPrice</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">closePrice</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">low</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">high</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">volume</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
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
<td style="border: 1px solid #dfe2e5;"></td>
<td style="border: 1px solid #dfe2e5;"></td>
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
<td style="border: 1px solid #dfe2e5;">orderId</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">O</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">instrumentId</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">O</td>
<td style="border: 1px solid #dfe2e5;">If not provided, orders for all symbols are returned</td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">status</td>
<td style="border: 1px solid #dfe2e5;"><p>Open, Executed,</p>
<p>Partial Executed, Cancelled</p></td>
<td style="border: 1px solid #dfe2e5;">O</td>
<td style="border: 1px solid #dfe2e5;">If not provided, orders for all status are returned</td>
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
<td style="border: 1px solid #dfe2e5;">orderId</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">instrumentId</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">userAccount</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;">User may have multiple accounts in firm user case.</td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">type</td>
<td style="border: 1px solid #dfe2e5;">Market, Limit, Stop, StopLimit</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">price</td>
<td style="border: 1px solid #dfe2e5;">DoubleString</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">size</td>
<td style="border: 1px solid #dfe2e5;">DoubleString</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">side</td>
<td style="border: 1px solid #dfe2e5;">Buy/Sell</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">timeInForce</td>
<td style="border: 1px solid #dfe2e5;">GTC, GTT, IOC, FOK</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">orderTime</td>
<td style="border: 1px solid #dfe2e5;">Timestamp</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">stopPrice</td>
<td style="border: 1px solid #dfe2e5;">DoubleString</td>
<td style="border: 1px solid #dfe2e5;">O</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">status</td>
<td style="border: 1px solid #dfe2e5;">Open, Executed, Cancelled</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">executedSize</td>
<td style="border: 1px solid #dfe2e5;">DoubleString</td>
<td style="border: 1px solid #dfe2e5;">O</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">executedPrice</td>
<td style="border: 1px solid #dfe2e5;">DoubleString</td>
<td style="border: 1px solid #dfe2e5;">O</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">postLiquidity</td>
<td style="border: 1px solid #dfe2e5;">Boolean</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;">True – order rest in the book initially</td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">fee</td>
<td style="border: 1px solid #dfe2e5;">DoubleString</td>
<td style="border: 1px solid #dfe2e5;">O</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">selfTradePrevention</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"><p>DC – Decrease and cancel</p>
<p>CO – Cancel oldest</p>
<p>CN – Cancel newest</p>
<p>CB – Cancel both</p></td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">clientOrderId</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">O</td>
<td style="border: 1px solid #dfe2e5;"></td>
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
<td style="border: 1px solid #dfe2e5;"></td>
<td style="border: 1px solid #dfe2e5;"></td>
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
<td style="border: 1px solid #dfe2e5;">orderId</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">O</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">instrumentId</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">O</td>
<td style="border: 1px solid #dfe2e5;">If not provided, orders for all symbols are returned</td>
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
<td style="border: 1px solid #dfe2e5;">time</td>
<td style="border: 1px solid #dfe2e5;">Timestamp</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">tradeId</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">userAccount</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">price</td>
<td style="border: 1px solid #dfe2e5;">DoubleString</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">size</td>
<td style="border: 1px solid #dfe2e5;">DoubleString</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">side</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;">Buy/Sell</td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">fee</td>
<td style="border: 1px solid #dfe2e5;">DoubleString</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">liquidity</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"><p>M – liquidity maker</p>
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
<td style="border: 1px solid #dfe2e5;"></td>
<td style="border: 1px solid #dfe2e5;"></td>
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
<td style="border: 1px solid #dfe2e5;">instrumentId</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">userAccount</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;">User account used for this order</td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">orderType</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;">Limit/Market/Stop/StopLimit</td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">price</td>
<td style="border: 1px solid #dfe2e5;">DoubleString</td>
<td style="border: 1px solid #dfe2e5;">(M)</td>
<td style="border: 1px solid #dfe2e5;">Mandatory if order is non Market order</td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">size</td>
<td style="border: 1px solid #dfe2e5;">DoubleString</td>
<td style="border: 1px solid #dfe2e5;">(M)</td>
<td style="border: 1px solid #dfe2e5;"><p>Mandatory if order is non Market order</p>
<p>For Market order, the user can either provide size or amount in quote currency</p></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">amount</td>
<td style="border: 1px solid #dfe2e5;">DoubleString</td>
<td style="border: 1px solid #dfe2e5;">O</td>
<td style="border: 1px solid #dfe2e5;">Amount in quote currency to buy/sell</td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">side</td>
<td style="border: 1px solid #dfe2e5;">Buy/Sell</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">timeInForce</td>
<td style="border: 1px solid #dfe2e5;">GTC, GTT, IOC FOK</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">clientOrderId</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">O</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">stopPrice</td>
<td style="border: 1px solid #dfe2e5;">NumberString</td>
<td style="border: 1px solid #dfe2e5;">(M)</td>
<td style="border: 1px solid #dfe2e5;">Mandatory if orderType is Stop or StopLimit</td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">postOnly</td>
<td style="border: 1px solid #dfe2e5;">Boolean</td>
<td style="border: 1px solid #dfe2e5;">O</td>
<td style="border: 1px solid #dfe2e5;">Default to false. If any part of the order results in taking liquidity, the order will be rejected and no part of it will execute.</td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">selfTradePrevention</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">O</td>
<td style="border: 1px solid #dfe2e5;"><p>Decrease and cancel (Default)</p>
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
<td style="border: 1px solid #dfe2e5;">clientOrderId</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">(M)</td>
<td style="border: 1px solid #dfe2e5;">Mandatory if clientOrderId is provided by the user</td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">orderId</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;">System generated unique order id</td>
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
<td style="border: 1px solid #dfe2e5;"></td>
<td style="border: 1px solid #dfe2e5;"></td>
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
<td style="border: 1px solid #dfe2e5;">orderId</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">clientOrderId</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">(M)</td>
<td style="border: 1px solid #dfe2e5;"></td>
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
<td style="border: 1px solid #dfe2e5;">orderId</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">(M)</td>
<td style="border: 1px solid #dfe2e5;">Mandatory if client order id is not provided</td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">clientOrderId</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">(M)</td>
<td style="border: 1px solid #dfe2e5;">Mandatory if order id is not provided</td>
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
<td style="border: 1px solid #dfe2e5;"></td>
<td style="border: 1px solid #dfe2e5;"></td>
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
<td style="border: 1px solid #dfe2e5;">orderIds</td>
<td style="border: 1px solid #dfe2e5;">Array of Strings</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;">Orders that are cancelled in the system</td>
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
<td style="border: 1px solid #dfe2e5;"></td>
<td style="border: 1px solid #dfe2e5;"></td>
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
<td style="border: 1px solid #dfe2e5;">userAccount</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">O</td>
<td style="border: 1px solid #dfe2e5;">Main account by default</td>
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
<td style="border: 1px solid #dfe2e5;">accountId</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">currency</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">balance</td>
<td style="border: 1px solid #dfe2e5;">DoubleString</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">available</td>
<td style="border: 1px solid #dfe2e5;">DoubleString</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
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
<td style="border: 1px solid #dfe2e5;"></td>
<td style="border: 1px solid #dfe2e5;"></td>
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
<td style="border: 1px solid #dfe2e5;">accountId</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">O</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">transactionType</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">O</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">referenceId</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">O</td>
<td style="border: 1px solid #dfe2e5;"></td>
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
<td style="border: 1px solid #dfe2e5;">transactionId</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">userAccount</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">accountId</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">currency</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">transactionType</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;">Trade/Deposit/Withdraw/Fee/Rebate/Order/PendingWithdraw</td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">amount</td>
<td style="border: 1px solid #dfe2e5;">DoubleString</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">balance</td>
<td style="border: 1px solid #dfe2e5;">DoubleString</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">available</td>
<td style="border: 1px solid #dfe2e5;">DoubleString</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">timestamp</td>
<td style="border: 1px solid #dfe2e5;">Timestamp</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">referenceId</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"><p>Additional information</p>
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
<td style="border: 1px solid #dfe2e5;"></td>
<td style="border: 1px solid #dfe2e5;"></td>
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
<td style="border: 1px solid #dfe2e5;">accountId</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">amount</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">address</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;">bankId or cryto address</td>
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
<td style="border: 1px solid #dfe2e5;">withdrawId</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
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
<td style="border: 1px solid #dfe2e5;"></td>
<td style="border: 1px solid #dfe2e5;"></td>
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
<td style="border: 1px solid #dfe2e5;">type</td>
<td style="border: 1px solid #dfe2e5;">error</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;">Error message type</td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">userMessageId</td>
<td style="border: 1px solid #dfe2e5;">Integer</td>
<td style="border: 1px solid #dfe2e5;">(M)</td>
<td style="border: 1px solid #dfe2e5;">Mandatory if userMessageId is provided in the user request</td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">errorCode</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;">Error code</td>
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
<td style="border: 1px solid #dfe2e5;">type</td>
<td style="border: 1px solid #dfe2e5;">subscribe</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;">Subscribe/Unsubscribe message type</td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">channel</td>
<td style="border: 1px solid #dfe2e5;">ticker</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">userMessageId</td>
<td style="border: 1px solid #dfe2e5;">Integer</td>
<td style="border: 1px solid #dfe2e5;">O</td>
<td style="border: 1px solid #dfe2e5;">Unique message id for this websocket session</td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">instrumentIds</td>
<td style="border: 1px solid #dfe2e5;">Array of instrumentId Strings</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
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
<td style="border: 1px solid #dfe2e5;">type</td>
<td style="border: 1px solid #dfe2e5;">subscribed</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;">Subscribe/Unsubscribe message type</td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">channel</td>
<td style="border: 1px solid #dfe2e5;">ticker</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">instrumentIds</td>
<td style="border: 1px solid #dfe2e5;">Array of instrumentId Strings</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">userMessageId</td>
<td style="border: 1px solid #dfe2e5;">Integer</td>
<td style="border: 1px solid #dfe2e5;">(M)</td>
<td style="border: 1px solid #dfe2e5;">Mandatory if userMessageId is provided in the user request</td>
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
<td style="border: 1px solid #dfe2e5;">type</td>
<td style="border: 1px solid #dfe2e5;">ticker</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">instrumentId</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;">e.g. “BTCUSD”</td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">time</td>
<td style="border: 1px solid #dfe2e5;">Timestamp</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">lastPrice</td>
<td style="border: 1px solid #dfe2e5;">DoubleString</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">bestBid</td>
<td style="border: 1px solid #dfe2e5;">DoubleString</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">bestAsk</td>
<td style="border: 1px solid #dfe2e5;">DoubleString</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">24hHigh</td>
<td style="border: 1px solid #dfe2e5;">DoubleString</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">24hLow</td>
<td style="border: 1px solid #dfe2e5;">DoubleString</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">24hVolume</td>
<td style="border: 1px solid #dfe2e5;">LongString</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">24hChange</td>
<td style="border: 1px solid #dfe2e5;">DoubleString</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
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
<td style="border: 1px solid #dfe2e5;"></td>
<td style="border: 1px solid #dfe2e5;"></td>
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
<td style="border: 1px solid #dfe2e5;">type</td>
<td style="border: 1px solid #dfe2e5;">subscribe</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;">Subscribe/Unsubscribe message type</td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">channel</td>
<td style="border: 1px solid #dfe2e5;">orderBook</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">depth</td>
<td style="border: 1px solid #dfe2e5;">Integer</td>
<td style="border: 1px solid #dfe2e5;">O</td>
<td style="border: 1px solid #dfe2e5;">Default to 25</td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">instrumentIds</td>
<td style="border: 1px solid #dfe2e5;">Array of instrumentId Strings</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">userMessageId</td>
<td style="border: 1px solid #dfe2e5;">Integer</td>
<td style="border: 1px solid #dfe2e5;">O</td>
<td style="border: 1px solid #dfe2e5;">Unique message id for this websocket session</td>
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
<td style="border: 1px solid #dfe2e5;">type</td>
<td style="border: 1px solid #dfe2e5;">subscribed</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;">Subscribe/Unsubscribe message type</td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">channel</td>
<td style="border: 1px solid #dfe2e5;">orderBook</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">depth</td>
<td style="border: 1px solid #dfe2e5;">Integer</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">instrumentIds</td>
<td style="border: 1px solid #dfe2e5;">Array of instrumentId Strings</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">userMessageId</td>
<td style="border: 1px solid #dfe2e5;">Integer</td>
<td style="border: 1px solid #dfe2e5;">(M)</td>
<td style="border: 1px solid #dfe2e5;">Mandatory if userMessageId is provided in the user request</td>
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
<td style="border: 1px solid #dfe2e5;">type</td>
<td style="border: 1px solid #dfe2e5;">orderBook</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">instrumentId</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">time</td>
<td style="border: 1px solid #dfe2e5;">Timestamp</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">bids</td>
<td style="border: 1px solid #dfe2e5;">Array of [price, size, numOfOrders]</td>
<td style="border: 1px solid #dfe2e5;">The aggregated size for each price level is returned with numOfOrders count for the price</td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">asks</td>
<td style="border: 1px solid #dfe2e5;">Array of [price, size, numOfOrders]</td>
<td style="border: 1px solid #dfe2e5;">The aggregated size for each price level is returned with numOfOrders count for the price</td>
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
<td style="border: 1px solid #dfe2e5;"></td>
<td style="border: 1px solid #dfe2e5;"></td>
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
<td style="border: 1px solid #dfe2e5;">type</td>
<td style="border: 1px solid #dfe2e5;">subscribe</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;">Subscribe/Unsubscribe message type</td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">channel</td>
<td style="border: 1px solid #dfe2e5;">fullOrderBook</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">instrumentIds</td>
<td style="border: 1px solid #dfe2e5;">Array of instrumentId Strings</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">userMessageId</td>
<td style="border: 1px solid #dfe2e5;">Integer</td>
<td style="border: 1px solid #dfe2e5;">O</td>
<td style="border: 1px solid #dfe2e5;">Unique message id for this websocket session</td>
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
<td style="border: 1px solid #dfe2e5;">type</td>
<td style="border: 1px solid #dfe2e5;">subscribed</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;">Subscribe/Unsubscribe message type</td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">channel</td>
<td style="border: 1px solid #dfe2e5;">fullOrderBook</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">instrumentIds</td>
<td style="border: 1px solid #dfe2e5;">Array of instrumentId Strings</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">userMessageId</td>
<td style="border: 1px solid #dfe2e5;">Integer</td>
<td style="border: 1px solid #dfe2e5;">(M)</td>
<td style="border: 1px solid #dfe2e5;">Mandatory if userMessageId is provided in the user request</td>
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
<td style="border: 1px solid #dfe2e5;">type</td>
<td style="border: 1px solid #dfe2e5;">fullOrderBook</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">instrumentId</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">orderId</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">price</td>
<td style="border: 1px solid #dfe2e5;">DoubleString</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">remainingSize</td>
<td style="border: 1px solid #dfe2e5;">DoubleString</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">status</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">side</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">sequence</td>
<td style="border: 1px solid #dfe2e5;">LongString</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
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
<td style="border: 1px solid #dfe2e5;"></td>
<td style="border: 1px solid #dfe2e5;"></td>
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
<td style="border: 1px solid #dfe2e5;">type</td>
<td style="border: 1px solid #dfe2e5;">subscribe</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;">Subscribe/Unsubscribe message type</td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">channel</td>
<td style="border: 1px solid #dfe2e5;">trades</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">instrumentIds</td>
<td style="border: 1px solid #dfe2e5;">Array of instrumentId Strings</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">userMessageId</td>
<td style="border: 1px solid #dfe2e5;">Integer</td>
<td style="border: 1px solid #dfe2e5;">O</td>
<td style="border: 1px solid #dfe2e5;">Unique message id for this websocket session</td>
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
<td style="border: 1px solid #dfe2e5;">type</td>
<td style="border: 1px solid #dfe2e5;">subscribed</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;">Subscribe/Unsubscribe message type</td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">channel</td>
<td style="border: 1px solid #dfe2e5;">trade</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">instrumentIds</td>
<td style="border: 1px solid #dfe2e5;">Array of instrumentId Strings</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">userMessageId</td>
<td style="border: 1px solid #dfe2e5;">Integer</td>
<td style="border: 1px solid #dfe2e5;">(M)</td>
<td style="border: 1px solid #dfe2e5;">Mandatory if userMessageId is provided in the user request</td>
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
<td style="border: 1px solid #dfe2e5;">type</td>
<td style="border: 1px solid #dfe2e5;">trades</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">time</td>
<td style="border: 1px solid #dfe2e5;">Timestamp</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">tradeId</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">price</td>
<td style="border: 1px solid #dfe2e5;">DoubleString</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">size</td>
<td style="border: 1px solid #dfe2e5;">DoubleString</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">side</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;">Buy/Sell</td>
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
<td style="border: 1px solid #dfe2e5;"></td>
<td style="border: 1px solid #dfe2e5;"></td>
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
<td style="border: 1px solid #dfe2e5;">type</td>
<td style="border: 1px solid #dfe2e5;">subscribe</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;">Subscribe/Unsubscribe message type</td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">channel</td>
<td style="border: 1px solid #dfe2e5;">charts</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">instrumentIds</td>
<td style="border: 1px solid #dfe2e5;">Array of instrumentId Strings</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">userMessageId</td>
<td style="border: 1px solid #dfe2e5;">Integer</td>
<td style="border: 1px solid #dfe2e5;">O</td>
<td style="border: 1px solid #dfe2e5;">Unique message id for this websocket session</td>
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
<td style="border: 1px solid #dfe2e5;">type</td>
<td style="border: 1px solid #dfe2e5;">subscribed</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;">Subscribe/Unsubscribe message type</td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">channel</td>
<td style="border: 1px solid #dfe2e5;">charts</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">instrumentIds</td>
<td style="border: 1px solid #dfe2e5;">Array of instrumentId Strings</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">userMessageId</td>
<td style="border: 1px solid #dfe2e5;">Integer</td>
<td style="border: 1px solid #dfe2e5;">(M)</td>
<td style="border: 1px solid #dfe2e5;">Mandatory if userMessageId is provided in the user request</td>
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
<td style="border: 1px solid #dfe2e5;">type</td>
<td style="border: 1px solid #dfe2e5;">charts</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">startTime</td>
<td style="border: 1px solid #dfe2e5;">Timestamp</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">openPrice</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">closePrice</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">low</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">high</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">volume</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
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
<td style="border: 1px solid #dfe2e5;"></td>
<td style="border: 1px solid #dfe2e5;"></td>
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
<td style="border: 1px solid #dfe2e5;">apiKey</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">signature</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">passPhrase</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">type</td>
<td style="border: 1px solid #dfe2e5;">newOrder</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">instrumentId</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">userAccount</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;">User account used for this order</td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">orderType</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;">Limit/Market/Stop/StopLimit</td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">price</td>
<td style="border: 1px solid #dfe2e5;">DoubleString</td>
<td style="border: 1px solid #dfe2e5;">(M)</td>
<td style="border: 1px solid #dfe2e5;">Mandatory if order is non Market order</td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">size</td>
<td style="border: 1px solid #dfe2e5;">DoubleString</td>
<td style="border: 1px solid #dfe2e5;">(M)</td>
<td style="border: 1px solid #dfe2e5;"><p>Mandatory if order is non Market order</p>
<p>For Market order, the user can either provide size or amount in quote currency</p></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">amount</td>
<td style="border: 1px solid #dfe2e5;">DoubleString</td>
<td style="border: 1px solid #dfe2e5;">O</td>
<td style="border: 1px solid #dfe2e5;">Amount in quote currency to buy/sell</td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">side</td>
<td style="border: 1px solid #dfe2e5;">Buy/Sell</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">timeInForce</td>
<td style="border: 1px solid #dfe2e5;">GTC, GTT, IOC FOK</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">clientOrderId</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">O</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">stopPrice</td>
<td style="border: 1px solid #dfe2e5;">NumberString</td>
<td style="border: 1px solid #dfe2e5;">(M)</td>
<td style="border: 1px solid #dfe2e5;">Mandatory if orderType is Stop or StopLimit</td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">postOnly</td>
<td style="border: 1px solid #dfe2e5;">Boolean</td>
<td style="border: 1px solid #dfe2e5;">O</td>
<td style="border: 1px solid #dfe2e5;">Default to false. If any part of the order results in taking liquidity, the order will be rejected and no part of it will execute.</td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">selfTradePrevention</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">O</td>
<td style="border: 1px solid #dfe2e5;"><p>Decrease and cancel (Default)</p>
<p>Cancel oldest;</p>
<p>Cancel newest;</p>
<p>Cancel both;</p></td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">userMessageId</td>
<td style="border: 1px solid #dfe2e5;">Integer</td>
<td style="border: 1px solid #dfe2e5;">O</td>
<td style="border: 1px solid #dfe2e5;">Unique message id for this websocket session</td>
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
<td style="border: 1px solid #dfe2e5;"></td>
<td style="border: 1px solid #dfe2e5;"></td>
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
<td style="border: 1px solid #dfe2e5;">apiKey</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">signature</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">passPhrase</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">type</td>
<td style="border: 1px solid #dfe2e5;">cancelOrder</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">orderId</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">(M)</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">clientOrderId</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">(M)</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">userMessageId</td>
<td style="border: 1px solid #dfe2e5;">Integer</td>
<td style="border: 1px solid #dfe2e5;">O</td>
<td style="border: 1px solid #dfe2e5;">Unique message id for this websocket session</td>
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
<td style="border: 1px solid #dfe2e5;"></td>
<td style="border: 1px solid #dfe2e5;"></td>
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
<td style="border: 1px solid #dfe2e5;">apiKey</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">signature</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">passPhrase</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">type</td>
<td style="border: 1px solid #dfe2e5;">subscribe</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;">Subscribe/Unsubscribe message type</td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">channel</td>
<td style="border: 1px solid #dfe2e5;">orderUpdate</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">instrumentIds</td>
<td style="border: 1px solid #dfe2e5;">Array of instrumentId Strings</td>
<td style="border: 1px solid #dfe2e5;">O</td>
<td style="border: 1px solid #dfe2e5;">Subscribe/Unsubscribe all instruments by default</td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">numberOfSnapshotRecords</td>
<td style="border: 1px solid #dfe2e5;">Integer</td>
<td style="border: 1px solid #dfe2e5;">O</td>
<td style="border: 1px solid #dfe2e5;">Max recent number of open orders returned. All open orders will be returned if not specified.</td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">userMessageId</td>
<td style="border: 1px solid #dfe2e5;">Integer</td>
<td style="border: 1px solid #dfe2e5;">O</td>
<td style="border: 1px solid #dfe2e5;">Unique message id for this websocket session</td>
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
<td style="border: 1px solid #dfe2e5;">type</td>
<td style="border: 1px solid #dfe2e5;">subscribed</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;">Subscribe/Unsubscribe message type</td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">channel</td>
<td style="border: 1px solid #dfe2e5;">orderUpdate</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">instrumentIds</td>
<td style="border: 1px solid #dfe2e5;">Array of instrumentId Strings</td>
<td style="border: 1px solid #dfe2e5;">O</td>
<td style="border: 1px solid #dfe2e5;">Subscribed/Unsubscribed for all instruments by default</td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">openOrders</td>
<td style="border: 1px solid #dfe2e5;">Array of orders Json Fields</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">userMessageId</td>
<td style="border: 1px solid #dfe2e5;">Integer</td>
<td style="border: 1px solid #dfe2e5;">(M)</td>
<td style="border: 1px solid #dfe2e5;">Mandatory if userMessageId is provided in the user request</td>
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
<td style="border: 1px solid #dfe2e5;">type</td>
<td style="border: 1px solid #dfe2e5;">orderUpdate</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">orderId</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">subaccount</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">instrumentId</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">type</td>
<td style="border: 1px solid #dfe2e5;">Market, Limit, Stop, StopLimit</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">price</td>
<td style="border: 1px solid #dfe2e5;">DoubleString</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">size</td>
<td style="border: 1px solid #dfe2e5;">DoubleString</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">side</td>
<td style="border: 1px solid #dfe2e5;">Buy/Sell</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">timeInForce</td>
<td style="border: 1px solid #dfe2e5;">GTC, GTT, IOC, FOK</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">orderTime</td>
<td style="border: 1px solid #dfe2e5;">Timestamp</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">stopPrice</td>
<td style="border: 1px solid #dfe2e5;">DoubleString</td>
<td style="border: 1px solid #dfe2e5;">O</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">status</td>
<td style="border: 1px solid #dfe2e5;"><p>Open,</p>
<p>Partially Filled, Filled, Cancelled</p></td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">executedSize</td>
<td style="border: 1px solid #dfe2e5;">DoubleString</td>
<td style="border: 1px solid #dfe2e5;">O</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">executedPrice</td>
<td style="border: 1px solid #dfe2e5;">DoubleString</td>
<td style="border: 1px solid #dfe2e5;">O</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">postLiquidity</td>
<td style="border: 1px solid #dfe2e5;">Boolean</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;">True – order rest in the book initially</td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">fee</td>
<td style="border: 1px solid #dfe2e5;">DoubleString</td>
<td style="border: 1px solid #dfe2e5;">O</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">selfTradePrevention</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"><p>DC – Decrease and cancel</p>
<p>CO – Cancel oldest</p>
<p>CN – Cancel newest</p>
<p>CB – Cancel both</p></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">clientOrderId</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">O</td>
<td style="border: 1px solid #dfe2e5;"></td>
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
<td style="border: 1px solid #dfe2e5;"></td>
<td style="border: 1px solid #dfe2e5;"></td>
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
<td style="border: 1px solid #dfe2e5;">apiKey</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">signature</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">type</td>
<td style="border: 1px solid #dfe2e5;">subscribe</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;">Subscribe/Unsubscribe message type</td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">channel</td>
<td style="border: 1px solid #dfe2e5;">accountUpdate</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">currencies</td>
<td style="border: 1px solid #dfe2e5;">Array of currency Strings</td>
<td style="border: 1px solid #dfe2e5;">O</td>
<td style="border: 1px solid #dfe2e5;">Subscribe for all currencies by default</td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">numberOfRecentTransactions</td>
<td style="border: 1px solid #dfe2e5;">Integer</td>
<td style="border: 1px solid #dfe2e5;">O</td>
<td style="border: 1px solid #dfe2e5;">Default to 100</td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">userMessageId</td>
<td style="border: 1px solid #dfe2e5;">Integer</td>
<td style="border: 1px solid #dfe2e5;">O</td>
<td style="border: 1px solid #dfe2e5;">Unique message id for this websocket session</td>
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
<td style="border: 1px solid #dfe2e5;">type</td>
<td style="border: 1px solid #dfe2e5;">subscribed</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;">Subscribe/Unsubscribe message type</td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">channel</td>
<td style="border: 1px solid #dfe2e5;">accounts</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">currencies</td>
<td style="border: 1px solid #dfe2e5;">Array of currency Strings</td>
<td style="border: 1px solid #dfe2e5;">O</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">accountBalances</td>
<td style="border: 1px solid #dfe2e5;">Array of account balances (accountId, currency, balance, availableBalance)</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">recentAccountUpdates</td>
<td style="border: 1px solid #dfe2e5;">Array of recent accountUpdate Json fields</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">userMessageId</td>
<td style="border: 1px solid #dfe2e5;">Integer</td>
<td style="border: 1px solid #dfe2e5;">(M)</td>
<td style="border: 1px solid #dfe2e5;">Mandatory if userMessageId is provided in the user request</td>
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
<td style="border: 1px solid #dfe2e5;">type</td>
<td style="border: 1px solid #dfe2e5;">accountUpdate</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">userAccount</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">transactionId</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">accountId</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">currency</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">transactionType</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;">Trade/Deposit/Withdraw/Fee/Rebate/Order/PendingWithdraw</td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">amount</td>
<td style="border: 1px solid #dfe2e5;">DoubleString</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">balance</td>
<td style="border: 1px solid #dfe2e5;">DoubleString</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">available</td>
<td style="border: 1px solid #dfe2e5;">DoubleString</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">timestamp</td>
<td style="border: 1px solid #dfe2e5;">Timestamp</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">referenceId</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"><p>Additional information</p>
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
<td style="border: 1px solid #dfe2e5;"></td>
<td style="border: 1px solid #dfe2e5;"></td>
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
<td style="border: 1px solid #dfe2e5;">username</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">O</td>
<td style="border: 1px solid #dfe2e5;">email as default</td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">email</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">Password</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;">Secured password</td>
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
<td style="border: 1px solid #dfe2e5;">registrationStatus</td>
<td style="border: 1px solid #dfe2e5;">“true”</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;">email as default</td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">messageCode</td>
<td style="border: 1px solid #dfe2e5;">“CHECK_EMAIL_TO_CONFIRM”</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;">Check email to confirm the registration</td>
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
<td style="border: 1px solid #dfe2e5;">USERNAME_IN_USE</td>
<td style="border: 1px solid #dfe2e5;">User name has been in use</td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">EMAIL_IN_USE</td>
<td style="border: 1px solid #dfe2e5;">User with the same email has already been registered and is active.</td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">EMAIL_REGISTERED_NON_ACTIVE</td>
<td style="border: 1px solid #dfe2e5;">User with the same email has already been registered, but is not active.</td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">BAD_PASSWORD</td>
<td style="border: 1px solid #dfe2e5;">Provided password does not meet the requirements</td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;"></td>
<td style="border: 1px solid #dfe2e5;"></td>
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
<td style="border: 1px solid #dfe2e5;">username</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">(M)</td>
<td style="border: 1px solid #dfe2e5;">User either provide username or email</td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">email</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">(M)</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">password</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
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
<td style="border: 1px solid #dfe2e5;">sessionToken</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
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
<td style="border: 1px solid #dfe2e5;"></td>
<td style="border: 1px solid #dfe2e5;"></td>
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
<td style="border: 1px solid #dfe2e5;">securityQuestions</td>
<td style="border: 1px solid #dfe2e5;">An array of Strings</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;">e.g. [“What is the name of your favorite movie”]</td>
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
<td style="border: 1px solid #dfe2e5;"></td>
<td style="border: 1px solid #dfe2e5;"></td>
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
<td style="border: 1px solid #dfe2e5;">username</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">(M)</td>
<td style="border: 1px solid #dfe2e5;">User either provide username or email</td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">email</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">(M)</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">securityAnswers</td>
<td style="border: 1px solid #dfe2e5;">An array of Json objects</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;">e.g. [{“What is the name of your favorite movie”:”Forrest Gump”}]</td>
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
<td style="border: 1px solid #dfe2e5;"></td>
<td style="border: 1px solid #dfe2e5;"></td>
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
<td style="border: 1px solid #dfe2e5;">email</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
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
<td style="border: 1px solid #dfe2e5;">EMAIL_IN_USE</td>
<td style="border: 1px solid #dfe2e5;">User with the same email has already been registered and is active.</td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;"></td>
<td style="border: 1px solid #dfe2e5;"></td>
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
<td style="border: 1px solid #dfe2e5;">currency</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">address</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">(M)</td>
<td style="border: 1px solid #dfe2e5;">Mandatory if currency is non-fiat currency</td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">despositInstruction</td>
<td style="border: 1px solid #dfe2e5;">A Json Object</td>
<td style="border: 1px solid #dfe2e5;">(M)</td>
<td style="border: 1px solid #dfe2e5;">Mandatory is currency is fiat currency</td>
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
<td style="border: 1px solid #dfe2e5;"></td>
<td style="border: 1px solid #dfe2e5;"></td>
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
<td style="border: 1px solid #dfe2e5;">email</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">O</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">username</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">O</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">oldPassword</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">(M)</td>
<td style="border: 1px solid #dfe2e5;">Mandatory if newPassword is provided</td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">newPassword</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">O</td>
<td style="border: 1px solid #dfe2e5;"></td>
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
<td style="border: 1px solid #dfe2e5;"></td>
<td style="border: 1px solid #dfe2e5;"></td>
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
<td style="border: 1px solid #dfe2e5;">name</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">permissions</td>
<td style="border: 1px solid #dfe2e5;">A JSON object</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;">e.g. {“accounts”:{“read”: true, “write”: “false”}, “orders”:{“read”: “true”, “write”:”true”}}</td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">userAccount</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">O</td>
<td style="border: 1px solid #dfe2e5;">associated user account</td>
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
<td style="border: 1px solid #dfe2e5;">name</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">apiKey</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">secret</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
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
<td style="border: 1px solid #dfe2e5;"></td>
<td style="border: 1px solid #dfe2e5;"></td>
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
<td style="border: 1px solid #dfe2e5;">keys</td>
<td style="border: 1px solid #dfe2e5;">An array of Json Objects with apiKey, userAccount and permissions</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;">e.g. [{“key”:”bot”, “userAccount”:”main”, “permissions”: {“accounts”:{“read”: true, “write”: “false”}, “orders”:{“read”: “true”, “write”:”true”}}}]</td>
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
<td style="border: 1px solid #dfe2e5;"></td>
<td style="border: 1px solid #dfe2e5;"></td>
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
<td style="border: 1px solid #dfe2e5;">seed</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
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
<td style="border: 1px solid #dfe2e5;"></td>
<td style="border: 1px solid #dfe2e5;"></td>
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
<td style="border: 1px solid #dfe2e5;">requiredFields</td>
<td style="border: 1px solid #dfe2e5;">A Json Object String</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">requiredFiles</td>
<td style="border: 1px solid #dfe2e5;">Array of Strings</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;">e.g. [“ID”, “Proof of Address”, “Proof of ID Holder”]</td>
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
<td style="border: 1px solid #dfe2e5;"></td>
<td style="border: 1px solid #dfe2e5;"></td>
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
<td style="border: 1px solid #dfe2e5;">requiredFields</td>
<td style="border: 1px solid #dfe2e5;">A Json Object String</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">requiredFiles</td>
<td style="border: 1px solid #dfe2e5;">A JSON object</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
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
<td style="border: 1px solid #dfe2e5;">name</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
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
<td style="border: 1px solid #dfe2e5;"></td>
<td style="border: 1px solid #dfe2e5;"></td>
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
<td style="border: 1px solid #dfe2e5;">userAccounts</td>
<td style="border: 1px solid #dfe2e5;">Array of Strings</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;">List of userAccounts associated with this user</td>
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
<td style="border: 1px solid #dfe2e5;"></td>
<td style="border: 1px solid #dfe2e5;"></td>
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
<td style="border: 1px solid #dfe2e5;">name</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">owner</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">accountNumber</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="even">
<td style="border: 1px solid #dfe2e5;">bankAddress</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
</tr>
<tr class="odd">
<td style="border: 1px solid #dfe2e5;">swiftCode</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
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
<td style="border: 1px solid #dfe2e5;">bankId</td>
<td style="border: 1px solid #dfe2e5;">String</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;"></td>
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
<td style="border: 1px solid #dfe2e5;"></td>
<td style="border: 1px solid #dfe2e5;"></td>
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
<td style="border: 1px solid #dfe2e5;">bankAccounts</td>
<td style="border: 1px solid #dfe2e5;">Array of Json Objects</td>
<td style="border: 1px solid #dfe2e5;">M</td>
<td style="border: 1px solid #dfe2e5;">List of userAccounts associated with this user. e.g. [{“bankId”:”xxxx”, “name”:”xxx”, “owner”:”xxxx”, “accountNumber”:”xxxx”, “bankAddress”:”xxxx”, “swiftCode”:”xxxx”}]</td>
</tr>
</tbody>
</table>

<a name="delete-bank-account" id="delete-bank-account"> </a>

### Delete Bank Account

DELETE /api/private/userAccounts/{bank account id}
