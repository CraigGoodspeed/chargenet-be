token=$(bash ./user_auth.sh | jq -r '.AuthenticationResult.AccessToken')
echo "${token}"
curl -X GET \
-H "Authorization: Bearer ${token}" \
http://localhost:8080/v1/product/info

curl -X GET \
-H "Authorization: Bearer ${token}" \
http://localhost:8080/admin/product/info

curl -X GET \
-H "Authorization: Bearer ${token}" \
http://localhost:8080/v1/product/admin/zaza