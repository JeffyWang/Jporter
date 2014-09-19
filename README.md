**A JSON converter for get our own JSON format.**


[![Build Status](https://travis-ci.org/JeffyWang/Jporter.svg)](https://travis-ci.org/JeffyWang/Jporter)


  Jport rely on [JSONPath](https://github.com/jayway/JsonPath) and [JSON Schema](http://json-schema.org/). It use the JSONPath to find the value from the source JSON, and put it in the result. In order to extend the description JSON, I let the description JSON looks like the JSON Schema
  
##Examples

Given the source JSON

```javascript
{
  "store": {
    "book": [
      {
        "category": "reference",
        "author": "Nigel Rees",
        "title": "Sayings of the Century",
        "price": 8.95
      },
      {
        "category": "fiction",
        "author": "Evelyn Waugh",
        "title": "Sword of Honour",
        "price": 12.99
      },
      {
        "category": "fiction",
        "author": "Herman Melville",
        "title": "Moby Dick",
        "isbn": "0-553-21311-3",
        "price": 8.99
      },
      {
        "category": "fiction",
        "author": "J. R. R. Tolkien",
        "title": "The Lord of the Rings",
        "isbn": "0-395-19395-8",
        "price": 22.99
      }
    ],
    "bicycle": {
      "color": "red",
      "price": 19.95
    }
  },
  "expensive": 10,
  "time": [
    "Monday",
    "Tuesday",
    "Wednesday",
    "Thursday",
    "Friday"
  ]
}
```

Call the method
```java
JSONObject json = JsonConvert.convert(sourceJson, resultJson);
```

###Get object
Get a JSON object from source JSON.

####Description JSON
```javascript
{
  "type": "object",
  "properties": {
    "bicycle": {
      "type": "object",
      "properties": {
        "color": {
          "type": "string",
          "path": "$.store.bicycle.color"
        }
      }
    }
  }
}
```
####Result
```javascript
{
  "bicycle": {
    "color": "red"
  }
}
```

###Get object array 
Get a JSON array from source JSON.
When getting array, we should add the **path** to the array object to get the source JSON arrya at first,  and if the properties' type is not object or array, we must let the source JSON array's object to the source JSON, and then add a real path.
Like this: 
```javascript
{
  "category": "fiction",
  "author": "Evelyn Waugh",
  "title": "Sword of Honour",
  "price": 12.99
}
```
And i get the path **$.category**.

####Description JSON
```javascript
{
  "type": "object",
  "properties": {
    "book": {
      "type": "object_array",
      "path": "$.store.book",
      "properties": {
        "category": {
          "type": "string",
          "path": "$.category"
        },
        "isbn": {
          "type": "string",
          "path": "$.isbn"
        },
        "price": {
          "type": "number",
          "path": "$.price"
        }
      }
    }
  }
}
```
####Result
```javascript
{
  "book": [
    {
      "category": "reference",
      "price": 8.95,
      "isbn": null
    },
    {
      "category": "fiction",
      "price": 12.99,
      "isbn": null
    },
    {
      "category": "fiction",
      "price": 8.99,
      "isbn": "0-553-21311-3"
    },
    {
      "category": "fiction",
      "price": 22.99,
      "isbn": "0-395-19395-8"
    }
  ]
}
```

###Get value array
Get a JSON object from source JSON.

####Description JSON
```javascript
{
  "type": "object",
  "properties": {
    "time": {
      "type": "string_array",
      "path": "$.time[1:4]"
    }
  }
}
```
####Result
```javascript
{
  "time": [
    "Tuesday",
    "Wednesday",
    "Thursday"
  ]
}
```

##Property type
The Jporter is in line with the type to analysis the source JSON, and there is the all type in it.

| Type                  | Description                                              |
| :---------------------| :--------------------------------------------------------|
| `object`              |   The source JSON is object                              |
| `object_array`        |   The source JSON is array, and the element is object    |
| `string_array`        |   The source JSON is array, and the element is string    |
| `number_array`        |   The source JSON is array, and the element is number    |
| `boolean_array`       |   The source JSON is array, and the element is boolean   |
| `string`              |   The source JSON is string                              |
| `number`              |   The source JSON is number                              |
| `boolean`             |   The source JSON is boolean                             |

##Binaries
Before use Jporter, we should add there dependencies into your pom.xml.
```xml
<dependency>
    <groupId>com.jayway.jsonpath</groupId>
    <artifactId>json-path</artifactId>
    <version>0.9.1</version>
</dependency>
<dependency>
    <groupId>net.sf.json-lib</groupId>
    <artifactId>json-lib</artifactId>
    <version>2.3</version>
    <classifier>jdk15</classifier>
</dependency>
```

> Written with [StackEdit](https://stackedit.io/).
