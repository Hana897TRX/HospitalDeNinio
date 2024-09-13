package jp.hanaHASAO.hospitaldelninio.data.local.user

import jp.hanaHASAO.hospitaldelninio.data.local.user.entity.UserEntity
import java.util.UUID

class UserLocalDataSourceImp: UserLocalDataSource {
    override suspend fun getAllUsers(): List<UserEntity> {
        return mockUp()
    }

    private fun mockUp(): List<UserEntity> {
        return listOf(
            UserEntity(
                uuid = UUID.randomUUID().toString(),
                name = "Hana HA",
                lastName = "Saotome",
                email = "hello1@example.com",
            ),
            UserEntity(
                uuid = UUID.randomUUID().toString(),
                name = "Hana RS",
                lastName = "Saotome",
                email = "hello2@example.com",
            ),
            UserEntity(
                uuid = UUID.randomUUID().toString(),
                name = "Hana MS",
                lastName = "Saotome",
                email = "hello3@example.com",
            ),
            UserEntity(
                uuid = UUID.randomUUID().toString(),
                name = "Hana YES",
                lastName = "Saotome",
                email = "hello4@example.com",
            ),
            UserEntity(
                uuid = UUID.randomUUID().toString(),
                name = "Haruna HA",
                lastName = "Saotome",
                email = "hello5@example.com",
            ),
            UserEntity(
                uuid = UUID.randomUUID().toString(),
                name = "花",
                lastName = "早乙女",
                email = "hello6@example.com",
            ),
            UserEntity(
                uuid = UUID.randomUUID().toString(),
                name = "春奈",
                lastName = "早乙女",
                email = "hello7@example.com",
            ),
            UserEntity(
                uuid = UUID.randomUUID().toString(),
                name = "春奈",
                lastName = "早乙女",
                email = "hello7@example.com",
            ),
            UserEntity(
                uuid = UUID.randomUUID().toString(),
                name = "春奈",
                lastName = "早乙女",
                email = "hello7@example.com",
            ),
            UserEntity(
                uuid = UUID.randomUUID().toString(),
                name = "春奈",
                lastName = "早乙女",
                email = "hello8@example.com"
            ),
            UserEntity(
                uuid = UUID.randomUUID().toString(),
                name = "春奈",
                lastName = "早乙女",
                email = "hello9@example.com"
            ),
            UserEntity(
                uuid = UUID.randomUUID().toString(),
                name = "春奈",
                lastName = "早乙女",
                email = "hello10@example.com"
            ),
            UserEntity(
                uuid = UUID.randomUUID().toString(),
                name = "春奈",
                lastName = "早乙女",
                email = "hello11@example.com"
            ),
        )
    }
}