#WEBSOCKET API

[**WEBSOCKET API**](#websocket-api)

[***General Information***](#general-information-1)

[Error Fields](#error-fields)

[***Public Channels***](#public-channels)

[Ticker](#ticker-1)

[Order Book](#order-book-1)

[Full Order Book channel](#full-order-book-channel)

[Trades](#trades-1)

[Charts](#charts-1)

[***Private Channels***](#private-channels)

[New Order](#new-order-1)

[Cancel Order](#cancel-order-1)

[Order Update](#order-update)

[Account Update](#account-update)

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
