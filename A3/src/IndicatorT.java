package src;

/**
* @brief This type provides the different possible indicators determined by the CEAB and faculty 
         of Engineering
* @detail Meanings of each are listed below:
*         math: competence in mathematics
*         specEngKnow: competence in specialized engineering knowledge
*         assumpt: ability to identify reasonable assumptions
*         suitableFund: ability to identify suitable engineering fundamentals
*         recogTheory: able to recognize and discuss applicable theory knowledge base
*         modelSelect: selects appropriate model methods
*         estOutcomes: estimates outcomes, uncertainties and determines data to collect
*         desProcess: recognizes and follows an engineering design process
*         desPrinciples: recognizes and follows engineering design principles
*         openEnded: proposes solutions to open-ended problems
*         ideaGeneration: employs appropriate techniques for generation of creative ideas
*         healthSafety: includes appropriate health and safety considerations
*         standards: determines and employs applicable standards and codes of practice
*         tools: the ability to use modern/state of the art tools
*         engInSoc: demonstrates an understanding of the role of the engineer in society
*         awarePEO: aware of PEO and role of licensing. 
*/


public enum IndicatorT {
    
    math, specEngKnow, assumpt, suitableFund, recogTheory, modelSelect, estOutcomes, desProcess,
    desPrinciples, openEnded, ideaGeneration, healthSafety, standards, tools, engInSoc, awarePEO;

}
