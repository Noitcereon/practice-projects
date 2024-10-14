# How to generate POJOs from the schemas

Depending on the schema you can do either:

`xjc [path-to-schema]`

Example:

`xjc ./src/main/resources/schemas/commontypes_v1.xsd`


Or

`xjc -p [package.path] [path-to-schema]`

`xjc -p me.noitcereon ./src/main/resources/schemas/my-schema.xsd`