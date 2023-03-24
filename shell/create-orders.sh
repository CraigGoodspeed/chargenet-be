token=$(bash ./auth.sh | jq -r '.AuthenticationResult.AccessToken')
curl -X PUT \
--data @./json/order-list.json \
-H "Authorization: Bearer ${token}" \
-H "content-type: application/json" \
http://localhost:8080/v1/order/bulk