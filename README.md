# DOCUMENTATION

<img src="https://i.postimg.cc/2jGvYfGg/Cover.png"/>

## ABOUT
The Quran application is a mobile application that runs on Android OS, which I cut from a design that I got for free from one of the UI/UX Designers at Figma and uses the Quran API to display a full list of Qurans in this application. I worked this for my portfolio project.

## START PROJECT
- To get the *completed code*, clone the repo or download the repo

## DESIGN
- You can download free the UI/UX Design to Slicing this mobile app design to DIY in <a href="https://www.figma.com/@tanvirux">Figma @tanvirux</a>. Thanks for providing free design so we're as developer is so nicely to practice in creating the app.

## API CONSUME

This application consumed the API from <a href="https://reqres.in">Reqres In Fake User</a>

### Get Users

Request :

- Method : GET
- Endpoint : `/api/users`
- Header :
  - Accept: application/json
  - Autohorization: Bearer token
- Query Param:
  - page: integer

Response :

```json
{
  "page": "integer",
  "per_page": "integer",
  "total": "integer",
  "total_pages": "integer",
  "data": [
    {
      "id": "integer",
      "email": "string, email",
      "first_name": "string",
      "last_name": "string",
      "avatar": "string",
    },
    ...
  ],
  "support": {
    "url": "string",
    "text": "string",
  }
}
```

## RESULT

<div style="display: flex">
  <img src="https://i.postimg.cc/yd3x9mBq/screencapture-localhost-3000-2023-01-16-01-12-29.png"/>
</div>

