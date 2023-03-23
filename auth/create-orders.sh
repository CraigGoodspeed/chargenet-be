token=$(bash ./admin_auth.sh | jq -r '.AuthenticationResult.AccessToken')
echo "${token}"

curl -X PUT \
--data @./json/order-list.json \
-H "Authorization: Bearer ${token}" \
-H "content-type: application/json" \
http://localhost:8080/v1/order/bulk