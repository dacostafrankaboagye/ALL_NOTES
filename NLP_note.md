
From :::: Hugging Face
# NLP
- NLP is a field of linguistics and machine learning focused on understanding everything related to human language. 
- NLP isn’t limited to written text though. It also tackles complex challenges in speech recognition
  and computer vision, such as generating a transcript of an audio sample or a description of an image
    
# Transformers
    Transformer models are used to solve all kinds of NLP tasks

## The pipeline function 
- A function that returns an end to end object, that performs NLP tasks on one or several texts
- It connects a model with its necessary preprocessing and postprocessing steps
-Some of the currently available pipelines are:
    - feature-extraction (get the vector representation of a text)
    - fill-mask
    - ner (named entity recognition)
    - question-answering
    - sentiment-analysis
    - summarization
    - text-generation
    - translation
    - zero-shot-classification

```bash
!pip install datasets evaluate transformers[sentencepiece]
from transformers import pipeline

classifier  = pipeline("sentiment-analysis")

# classifier([
#     "I have to do all I can to learn more"
# ])

classifier(
    ["I've been waiting for a HuggingFace course my whole life.", "I hate this so much!"]
)

# result
[{'label': 'POSITIVE', 'score': 0.9598048329353333},
 {'label': 'NEGATIVE', 'score': 0.9994558691978455}]
```

### Zero-shot classification
        This pipeline is called zero-shot because you don’t need to fine-tune the model on your data to use it.
        It can directly return probability scores for any list of labels you want!

```py

from transformers import pipeline 

classifier = pipeline('zero-shot-classification')

classifier(
    "Ghana is going to be a developed nation one day",
    candidate_labels=["politics", "society", "development"],
)

'''

{'sequence': 'Ghana is going to be a developed nation one day',
 'labels': ['development', 'society', 'politics'],
 'scores': [0.9058098196983337, 0.08858248591423035, 0.0056077660992741585]
}

from the result is more about development, that the other labels, with  a
confidence of about 91%


'''

```
### Text generation.

    - Text generation involves randomness. 
    - Uses input prompt to generate a text
    - it will auto complete a given prompt
    - ouput changes each time you call the generator object

```py
from transformers import pipeline 

generator = pipeline("text-generation")
generator("During Spring, all students")

# result
[{'generated_text': 'During Spring, all students attending the University of Massachusetts
system of Harvard need to enroll in online exams—a basic exam that requires students
to do at least 100 hours of work weekly and includes standardized test feedback.\n\nThis was the case with the Stanford'}]

```
## Using model

```py
from transformers import pipeline 

generator = pipeline("text-generation", model="distilgpt2")
generator(
    "I will be going to church to",
    max_length=30,
    num_return_sequences=2,
)

# result

[{'generated_text': "I will be going to church to help the kids, they are going
to need to help with these issues. We can help them, so I'm"},
 {'generated_text': "I will be going to church to protect her. She looks like a
crazy person, but you really don't have to worry much about them.�"}]

```


### Mask Filling
    - fill in the blanks in a given text
    - The top_k argument controls how many possibilities you want to be displayed.
    - <mask> mask token
```py
from transformers import pipeline 

unmasker = pipeline("fill-mask")
unmasker("I <mask> go to service today.", top_k=3)


# result
[{'score': 0.6117568016052246,
  'token': 581,
  'token_str': "'ll",
  'sequence': "I'll go to service today."},
 {'score': 0.18625882267951965,
  'token': 40,
  'token_str': ' will',
  'sequence': 'I will go to service today.'},
 {'score': 0.03786023333668709,
  'token': 1017,
  'token_str': "'d",
  'sequence': "I'd go to service today."}]
```


### Named entity recognition
    - the model has to find which parts of the input text correspond to entities such as persons, locations, or organization
    - grouped_entities=True in the pipeline creation function to tell the pipeline to 
     regroup together the parts of the sentence that correspond to the same entity

```py
from transformers import pipeline 
ner = pipeline("ner", grouped_entities=True)
ner("My name is Frank. I am a graduate of ASH University")

# result
[{'entity_group': 'PER',
  'score': 0.99868065,
  'word': 'Frank',
  'start': 11,
  'end': 16},
 {'entity_group': 'ORG',
  'score': 0.9925334,
  'word': 'ASH University',
  'start': 37,
  'end': 51}]

```


### Question answering
    this pipeline works by extracting information from the provided context; it does not generate the answer.

```py
from transformers import pipeline 

question_answerer = pipeline("question-answering")
question_answerer(
    question="What do I want to be in future?",
    context="My name is Frank Aboaye. I completed Ashesi University and my future dream is to be a good Engineer"
)
```

### Summarization

```py
from transformers import pipeline 
summarizer = pipeline("summarization")
summarizer(
    """
    As a fourth-year Electrical and Electronics Engineering student 
    at Ashesi University, I am passionate about exploring the latest 
    advancements in the field of engineering. Having completed my 
    secondary education at St Augustine's College where I was an
    active member of the Child Rights Club and the Science Club, 
    I developed communication and problem solving skills.
    I take pride in delivering exceptional results through carefully
    planned and executed tasks. My interest in networking, computing,
    circuits, security and learning technologies has enabled me to acquire 
    a comprehensive technical skill set. In addition, I am an avid software 
    programmer and enjoy taking on challenging projects to further 
    develop my knowledge. Aside from my technical knowledge, 
    I am a well-rounded individual. I enjoy engaging in physical 
    activities such as playing basketball, which helps me stay physically 
    active. I also enjoy listening to podcasts and playing chess in my spare time.
    """
)

# result

[{'summary_text': ' As a fourth-year Electrical and Electronics Engineering student,
I am passionate about exploring the latest  advancements in the field of engineering .
I take pride in delivering exceptional results through carefully planned and executed tasks .
I am an avid software programmer and enjoy taking on challenging projects to further develop my knowledge .'}]

```
---

what’s inside a pipeline() function? and how do we customize its behavior?










