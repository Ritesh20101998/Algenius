import express from 'express';
import * as dotenv from 'dotenv';
import cors from 'cors';
import { Configuration, OpenAIApi } from 'openai';

dotenv.config();

const configuration = new Configuration({
    apiKey: process.env.OPEN_API_KEY,
})

const openai = new OpenAIApi(configuration);

// console.log(openai)

const app = express();
app.use(cors());
app.use(express.json());

app.get('/', async(req, res) => {
    res.status(200).send({message:"codex from Rk"})
})

app.post('/chat', async(req, res) => {
    console.log(req.body)
    try{    
        const prompt = req.body.prompt;

        console.log(prompt);

        const response = await openai.createCompletion({
            model: "text-davinci-003",
            prompt: `${prompt}`,
            temperature: 0,
            max_tokens: 300,
            top_p: 1,
            frequency_penalty: 0.5,
            presence_penalty: 0,
        })

        // console.log(response)

        res.status(200).send({
            bot:response.data.choices[0].text
        })
    } catch(error){
        // console.log(error)
        res.status(500).send('something wrong')
    }
})

app.listen(5000,()=>console.log('AI server started on http://localhost:5000'))