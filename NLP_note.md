
From :: Hugging Face
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

### Text generation
















