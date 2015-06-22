# javaee-push-notification-server
A JavaEE backend push notification server

## GCM Android


### REST API for sending push message to Android devices:
http://localhost:8080/push-notification-service/rest/sendGCM
### HTTP POST method with Payload:

{
  "appKey": "appKey_xyz",
  "gcmMessage": {
      "data": {
          "title": "title test",
          "text": "text test"
      },
      "to": "regId_xyz"
    }
}

- "appkey" is the GCM server's app key for sending push messages to Google GCM.
- "to" is the regId of android's device for receiving push messages from Google GCM. 

### Result:
{
    "status":200,
    "message":null,
    "multicast_id":xyz,
    "success":true,
    "failure":false,
    "canonical_ids":0,
    "results": [{
        "message_id":"0:xyz"
    }]
}
